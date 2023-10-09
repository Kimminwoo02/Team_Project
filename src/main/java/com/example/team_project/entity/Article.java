package com.example.team_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@NoArgsConstructor

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "memberId")
    private Member member;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Column(nullable = false, length = 10000)
    private String content;

    @Builder
    public Article(String title, String content,Member member){
        this.title = title;
        this.content = content;
        this.member = member;
    }

}
