package com.example.publishingservice.controller;

import com.example.publishingservice.models.ArticleDBModel;
import com.example.publishingservice.models.ArticleDTO;
import com.example.publishingservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<?> getArticle(String id) {
        Optional<ArticleDBModel> articleDBModelOptional = articleService.getArticle(id);

        if (articleDBModelOptional.isPresent()){
            return ResponseEntity.ok(articleDBModelOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Article no longer exists");
        }
    }

    @PostMapping
    public ResponseEntity<String> createArticle(
            @RequestBody ArticleDTO articleDTO
    ) {
        return ResponseEntity.ok(articleService.create(articleDTO));
    }
}
