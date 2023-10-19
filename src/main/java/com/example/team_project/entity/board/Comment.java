package com.example.team_project.entity.board;

import com.example.team_project.entity.member.Member;
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

    private Long memberId;
    private String commentWriter;
    @Column
    private String commentContents;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="boardId")
    private Board board; //boardEntity에 코드 추가해야할 것. private List<Comment> commentList = new ArrayList<>();

    public Comment(Long memberId, String commentContents){
        this.memberId = memberId;
        this.commentContents = commentContents;
    }

    public static Comment toComment(Long memberId, String commentContents, Board board){
        return Comment.builder()
                .memberId(memberId)
                .commentContents(commentContents)
                .board(board)
                .build();
    }

}
