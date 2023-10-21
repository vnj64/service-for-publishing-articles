package com.example.publishingservice.utils;

import com.example.publishingservice.models.ArticleDBModel;
import com.example.publishingservice.models.ArticleDTO;
import com.example.publishingservice.repository.ArticleRepository;
import com.ibm.icu.text.Transliterator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ArticleMapper {

    @Autowired
    private ArticleRepository articleRepository;
    Transliterator transliterator = Transliterator.getInstance("Cyrillic-Latin");

    public ArticleDBModel mapDTOtoDBModel(ArticleDTO articleDTO) {
        return new ArticleDBModel(
                generateId(articleDTO.getName(), articleDTO.getDate()),
                articleDTO.getTitle(),
                articleDTO.getName(),
                articleDTO.getDate(),
                articleDTO.getBody()
        );
    }

    private String generateId(String name, Date date) {
        String id = transliterator.transliterate(name) + "-" + date;
        if (articleRepository.existsById(id)){
            id += ".2";
        }
        return id;
    }
}
