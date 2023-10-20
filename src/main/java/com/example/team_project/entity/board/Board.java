package com.example.team_project.entity.board;

import com.example.team_project.entity.AuditingFields;
import com.example.team_project.entity.Category;
import com.example.team_project.entity.member.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Board extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;

    @Setter
    @Column(name = "title")
    private String title;

    @Setter
    @Column(name = "content", length = 50000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @Setter
    @Enumerated(EnumType.STRING)
    private Category category;


    @JsonBackReference
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Comment> comments;




    @Builder
    public Board(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public static Board toBoard(String title, String content, Member member) {
        return Board.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }

}
