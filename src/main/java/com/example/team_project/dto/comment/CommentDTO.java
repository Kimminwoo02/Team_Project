package com.example.team_project.dto.comment;

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
    private Long boardId;
    private Long memberId;
    public static CommentDTO toCommentDTO(Comment comment, Long boardId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(me.getId());
        commentDTO.setCommentWriter(comment.getCommentWriter());
        commentDTO.setCommentContents(comment.getCommentContents());
        commentDTO.setBoardId(boardId);
        return commentDTO;
    }



}
