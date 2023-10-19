package com.example.team_project.dto.Board;

import com.example.team_project.entity.Category;
import com.example.team_project.entity.member.Member;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class BoardDTO {
    private Long boardId;
    @Setter
    private String title;
    @Setter
    private String content;
    private Member member;
    @Setter
    private Category category;
    private LocalDateTime createdAt;

    public BoardDTO(Long boardId, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }
}
