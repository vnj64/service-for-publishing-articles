package com.example.publishingservice.repositories;

import com.example.publishingservice.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
