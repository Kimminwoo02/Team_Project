package com.example.team_project.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.example.team_project.entity.board.Comment;

@Getter
@Setter
@AllArgsConstructor
public class CommentDTO {
    private Long id;
    private Long memberId;
    private String commentWriter;
    private String commentContents;
    private Long boardId;

    public Comment toComment(){
        return Comment.builder()
                .commentContents(commentContents)
                .commentWriter(commentWriter)
                .build();

    }

    public static CommentDTO from(Comment entity) {
        return new CommentDTO(
                entity.getId(),
                entity.getMemberId(),
                entity.getCommentWriter(),
                entity.getCommentContents(),
                entity.getBoard().getBoardId()
        );
    }


}
