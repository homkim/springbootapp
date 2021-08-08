package com.example.myapp.api;

import com.example.myapp.dto.ArticleForm;
import com.example.myapp.entity.Article;
import com.example.myapp.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/api/articles/{id}")
    public ArticleForm getArticle(@PathVariable Long id) {
        Article entity = articleRepository.findById(id) // id로 article을 가져옴!
                .orElseThrow( // 만약에 없다면,
                        () -> new IllegalArgumentException("해당 Article이 없습니다.") // 에러를 던짐!
                );
        // article을 form으로 변경! 궁극적으로는 JSON으로 변경 됨! 왜? RestController 때문!
        return new ArticleForm(entity);
        
    }

    @PutMapping("/api/articles/{id}") // HTTP 메소드 PUT으로 "/api/articles/{id}" 요청이 들어오면 수행!
    public Long update(@PathVariable Long id,
                       @RequestBody ArticleForm form) {
        log.info("form: " + form.toString()); // 받아온 데이터 확인!
        return 0L;
    }
    
}
