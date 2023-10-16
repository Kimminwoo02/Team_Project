package com.example.team_project.dto.comment;

import com.example.team_project.entity.Board;
import com.example.team_project.entity.Facility;
import com.example.team_project.entity.Member;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.example.team_project.entity.Comment;

@Getter
@Setter
@ToString
public class CommentDTO {
    private Long id;
    private String commentWriter;
    private String commentContents;
    private Board board;
    private Long memberId;

    public Comment toComment(){
        return Comment.builder()
                .commentContents(commentContents)
                .commentWriter(commentWriter)
                .board(board)
                .build();

    }


}
