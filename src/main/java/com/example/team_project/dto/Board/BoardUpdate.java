package com.example.team_project.dto.Board;

import com.example.team_project.entity.Board;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
@Setter
public class BoardUpdate {
    private String title;
    private String content;

    public Board toBoardEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }

}
