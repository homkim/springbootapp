package com.example.myapp.dto;

import com.example.myapp.entity.Article;

import lombok.Data;   // @Data 하나로 통합
import lombok.NoArgsConstructor;

// import lombok.AllArgsConstructor;
// import lombok.ToString;

@NoArgsConstructor
// @ToString

@Data  // 생성자(디폴트 All), getter, setter, toString 알아서 다 만들어줌
public class ArticleForm {
    private Long id;   //id 필드 추가
    private String title;
    private String content;
    
    // @AllArgsConstructor 으로 생성자 리펙토링
    
    // public ArticleForm(String title, String content) {
    //     this.title = title;
    //     this.content = content;
    // }

    // 생성자: entity 객체를 form으로 변환.
    public ArticleForm(Article entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }    

    // @ToString 으로 리펙토링
    /*
    @Override
    public String toString() {
        return "ArticleForm [title=" + title + ", content=" + content + "]";
    }
    */

    public Article toEntity() {

        // Build 패턴으로 객체 생성! 입력순서 일치하지 않아도 됨
        // return new Article(null, title, content);
        return Article.builder() //@Builder 어노테이션 적용
                .id(null)
                .title(title)
                .content(content)
                .build();
    }

    
}
