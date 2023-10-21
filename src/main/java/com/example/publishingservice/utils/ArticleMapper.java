package com.example.publishingservice.utils;

import com.example.publishingservice.models.ArticleDBModel;
import com.example.publishingservice.models.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
