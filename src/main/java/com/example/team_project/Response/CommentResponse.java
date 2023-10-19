package com.example.team_project.Response;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class CommentResponse {
    private String commentWriter;
    private Long memberId;
    private String commentContents;

    public CommentResponse(String commentWriter, Long memberId , String commentContents) {
        this.commentWriter=commentWriter;
        this.memberId =memberId;
        this.commentContents = commentContents;
    }

    // Getter and Setter methods


}