package com.example.publishingservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {

    private String title;
    private String coverImage;
    private String name;
    private String date;
    private String body;
    private String articleTheme;
    private String theme;
}
