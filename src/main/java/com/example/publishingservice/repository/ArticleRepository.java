package com.example.publishingservice.repository;

import com.example.publishingservice.models.ArticleDBModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ArticleRepository extends JpaRepository<ArticleDBModel, String> {
}
