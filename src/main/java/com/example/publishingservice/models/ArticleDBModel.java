package com.example.publishingservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Article")
public class ArticleDBModel {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "cover_image")
    private String coverImage;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private String date;
    @Column(name = "body")
    private String body;
    @Column(name = "theme")
    private String theme;
}
