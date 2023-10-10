package com.example.team_project.dto.Board;

import com.example.team_project.entity.Board;
import com.example.team_project.entity.Member;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class BoardDTO {
    private Long boardId;
    private String title;
    private String content;
    private Member member;
    private Long memberId;

    @Builder
    public BoardDTO(Long boardId, String title, String content){
        this.boardId = boardId;
        this.title=title;
        this.content=content;
    }

}
