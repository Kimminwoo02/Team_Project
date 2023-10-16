package com.example.team_project.dto.Board;

import com.example.team_project.entity.Board;
import com.example.team_project.entity.Category;
import com.example.team_project.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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
