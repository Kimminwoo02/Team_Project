package com.example.team_project.dto.article;

import com.example.team_project.entity.Article;
import com.example.team_project.entity.Member;
import lombok.Data;

@Data
public class CreateArticle {
    private String title;
    private String content;
    private Member member;


    public Article toCreateArticle(){
        return  Article.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();

    }
}
