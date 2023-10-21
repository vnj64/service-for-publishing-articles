package com.example.publishingservice.service;

import com.example.publishingservice.models.ArticleDBModel;
import com.example.publishingservice.models.ArticleDTO;
import com.example.publishingservice.repository.ArticleRepository;
import com.example.publishingservice.utils.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleMapper articleMapper;

    public String create(ArticleDTO articleDTO) {
        ArticleDBModel articleDBModel = articleMapper.mapDTOtoDBModel(articleDTO);
        articleRepository.save(articleDBModel);
        return articleDBModel.getId();
    }

    public Optional<ArticleDBModel> getArticle(String id){
        return articleRepository.findById(id);
    }
}
