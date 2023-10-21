package com.example.publishingservice.utils;

import com.ibm.icu.text.Transliterator;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class ArticleUrlGenerator {
    public static String generateArticleUrl(String title, String date) {
        Transliterator transliterator = Transliterator.getInstance("Any-Latin; NFD; [:Nonspacing Mark:] Remove; NFC");
        String titleTransliterated = transliterator.transliterate(title)
                .replace(" ", "")
                .replaceAll("[^a-zA-Z0-9-]", "-")
                .replaceAll("-{2,}", "-");

        try {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM-dd");
            Date dateObj = inputDateFormat.parse(date);
            String dateUrl = outputDateFormat.format(dateObj);

            String articleUrl = "/" + titleTransliterated + dateUrl;
            return articleUrl;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String title = "Кейс от Вебпрактик (блог-платформа)";
        String date = "2023-10-15";
        String url = generateArticleUrl(title, date);
        System.out.println(url);
    }
}
