package com.example.team_project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private Long boardId;

    @Column(name="title")
    private String title;

    @Column(name="content", length = 10000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;
    @Builder
    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }

    public static Board toBoard(String title, String content, Member member){
        return Board.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }

}
