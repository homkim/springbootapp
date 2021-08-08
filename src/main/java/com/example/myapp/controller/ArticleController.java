package com.example.myapp.controller;

import com.example.myapp.dto.ArticleForm;
import com.example.myapp.entity.Article;
import com.example.myapp.repository.ArticleRepository;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor // final 필드 값을 알아서 가져옴(@Autowired 대체)
@Slf4j
public class ArticleController {
    
    // @Autowired -> @RequiredArgsConstructor로 대체 : !!final 붙여야 함!!
    private final ArticleRepository articleRepository;

    @GetMapping("/articles")
    public String index(Model model){ //뷰로 전달하기 위한 모델 객체 자동삽입
        // 모든 Article을 가져옴
        // Iterable 인터페이스는 ArrayList의 부모 인터페이스
        Iterable<Article> articleList = articleRepository.findAll();

        // 뷰페이지로 articles 전달
        model.addAttribute("articles", articleList);

        // 뷰페이지 설정
        return "articles/index";
    }

    @GetMapping("/articles/new")
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
