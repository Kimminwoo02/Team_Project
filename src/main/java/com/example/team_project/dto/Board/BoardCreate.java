package com.example.team_project.dto.Board;

import com.example.team_project.entity.board.Board;
import com.example.team_project.entity.Category;
import com.example.team_project.entity.member.Member;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class BoardCreate {
    private String title;
    private String content;
    private Member member;
    private Category category;

    public Board toBoardEntity(){
        return Board.builder()
                .title(title)
                .content(content.substring(1))
                .member(member)
                .category(category)
                .build();
    }
}
