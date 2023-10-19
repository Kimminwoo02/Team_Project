package com.example.team_project.dto.matching;

import com.example.team_project.entity.Category;
import com.example.team_project.entity.matching.Matching;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MatchingDTO {
    private Long matchingId;
    private Long memberId;
    private String matchingName;
    private String level;
    private String content;
    private String address;
    private String capacity;
    private Category category;
    private String sDate;


    public Matching createMatching(){
        return Matching.builder()
                .memberId(memberId)
                .matchingName(matchingName)
                .level(level)
                .content(content)
                .address(address)
                .sDate(sDate)
                .capacity(capacity)
                .category(category)
                .build();
    }

}
