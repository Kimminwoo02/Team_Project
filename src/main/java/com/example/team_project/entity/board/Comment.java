package com.example.team_project.entity.board;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="comment_table")
@Builder
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String commentWriter;

    @Column
    private String commentContents;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="boardId")
    private Board board; //boardEntity에 코드 추가해야할 것. private List<Comment> commentList = new ArrayList<>();




    public Comment(String commentWriter, String commentContents){
        this.commentWriter = commentWriter;
        this.commentContents = commentContents;
    }

    public static Comment toComment(String commentWriter, String commentContents, Board board){
        return Comment.builder()
                .commentWriter(commentWriter)
                .commentContents(commentContents)
                .board(board)
                .build();
    }

}
