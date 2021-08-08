package com.example.myapp.api;

import com.example.myapp.dto.ArticleForm;
import com.example.myapp.entity.Article;
import com.example.myapp.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ArticleApiController {

    @Autowired
    private ArticleRepository articleRepository;
    
    @PostMapping("/api/articles") // Post 요청이 "/api/articles"로 들어오는 경우 처리
    public Long create(@RequestBody ArticleForm form) { // Json 데이터를 받아옴
        log.info(form.toString() + "::form"); // 받아온 데이터 확인

        Article article = form.toEntity();
        log.info(article.toString() + "::article");

        Article saved = articleRepository.save(article);
        log.info(saved.toString() + "::saved");

        return saved.getId();
    }
    
}
