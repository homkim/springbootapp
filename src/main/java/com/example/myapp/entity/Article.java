package com.example.myapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Entity //DB가 해당 객체 인식가능
public class Article {

    @Id // 대표값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 1,2,3 자동생성
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "text", nullable = false)
    private String content;

    @Builder
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


    // @AllArgsConstructor 으로 리펙토링
    /*
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    */

    // @ToString 으로 리펙토링
    /*
    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
    }
    */
    
}
