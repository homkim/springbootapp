package com.example.myapp.controller;

import com.example.myapp.dto.ArticleForm;
import com.example.myapp.entity.Article;
import com.example.myapp.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ArticleController {
    
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles")
    public String articleList(){

        return "articles/index";
    }

    @PostMapping("/articles/new")
    public String newArticleForm(){

        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){

        
        // 서버에 부하를 주는 문법으로 로깅으로 변경한다
        // 아래도 모두 변경해준다.
        /*
        System.out.println(form.toString()); 
        */
        log.info(form.toString());

        // 1.DTO를 Entity로 변환
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());

        // 2.Repository에게 Entity를 DB안에 저장
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString() + " : 잘 저장되었습니다!!");

        return "redirect:/articles";
    }
}
