package com.example.publishingservice.utils;

import com.example.publishingservice.repository.ArticleRepository;
import com.ibm.icu.text.Transliterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleIdHelper {

    @Autowired
    private ArticleRepository articleRepository;
    Transliterator transliterator = Transliterator.getInstance("Cyrillic-Latin");

    public String generateId(String name, String date) {

        String id = transliterator.transliterate(name)
                .trim()
                .replace(" ", "")
                .replaceAll("[^a-zA-Z0-9-]", "-") + "-" + date;

        id = id.replaceAll("-{2,}", "-");

        int version = 0;
        while (true){
            if (articleRepository.existsById(id + "-" + version))
                version++;
            else{
                id += "-" + version;
                break;
            }
        }

        return id;
    }
}
