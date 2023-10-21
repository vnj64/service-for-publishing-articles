package com.example.publishingservice.services;

import com.example.publishingservice.models.Article;
import com.example.publishingservice.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article createArticles(Article article) {
        return articleRepository.save(article);
    }
}
