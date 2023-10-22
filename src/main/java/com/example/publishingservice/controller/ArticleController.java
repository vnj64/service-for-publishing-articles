package com.example.publishingservice.controller;

import com.example.publishingservice.models.ArticleDBModel;
import com.example.publishingservice.models.ArticleDTO;
import com.example.publishingservice.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin
@Api(tags = "Articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    @ApiOperation("Get article by ID")
    public ResponseEntity<?> getArticle(
            @ApiParam("Gets article by ID")
            String id
    ) {
        Optional<ArticleDBModel> articleDBModelOptional = articleService.getArticle(id);

        if (articleDBModelOptional.isPresent()){
            return ResponseEntity.ok(articleDBModelOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Article no longer exists");
        }
    }

    @PostMapping
    @ApiOperation("Create article")
    public ResponseEntity<String> createArticle(
            @ApiParam("Creates article")
            @RequestBody ArticleDTO articleDTO
    ) {
        return ResponseEntity.ok(articleService.create(articleDTO));
    }
}
