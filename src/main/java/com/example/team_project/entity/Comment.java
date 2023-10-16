package com.example.team_project.entity;

import com.example.team_project.dto.comment.CommentDTO;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="comment_table")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String commentWriter;

   @Column
    private String commentContents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="boardId")
    private Board board; //boardEntity에 코드 추가해야할 것. private List<Comment> commentList = new ArrayList<>();

    //board 엔티티가 추가되면 수정할 것.
    public static Comment toSaveEntity(Member member, Board board)  {
        Comment comment = new Comment();
        comment.setCommentWriter(commentDTO.getCommentWriter());
        comment.setCommentContents(commentDTO.getCommentContents());
        comment.setBoard(board);
        return comment;
    }
}
