package com.example.myapp.repository;

import com.example.myapp.entity.Article;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    
}
