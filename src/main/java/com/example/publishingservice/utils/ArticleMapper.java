package com.example.publishingservice.utils;

import com.example.publishingservice.models.ArticleDBModel;
import com.example.publishingservice.models.ArticleDTO;
import com.example.publishingservice.repository.ArticleRepository;
import com.ibm.icu.text.Transliterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ArticleMapper {
    @Autowired
    private ArticleIdHelper articleIdHelper;
    public ArticleDBModel mapDTOtoDBModel(ArticleDTO articleDTO) {
        return new ArticleDBModel(
                articleIdHelper.generateId(articleDTO.getTitle(), articleDTO.getDate()),
                articleDTO.getTitle(),
                articleDTO.getName(),
                articleDTO.getDate(),
                articleDTO.getBody()
        );
    }
}
