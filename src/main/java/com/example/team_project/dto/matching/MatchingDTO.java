package com.example.team_project.dto.matching;

import com.example.team_project.entity.Category;
import com.example.team_project.entity.matching.Matching;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchingDTO {
    private Long matchingId;
    private Long memberId;
    private String matchingName;
    private String level;
    private String content;
    private String address;
    private String capacity;
    private Category category;


    public Matching createMatching(){
        return Matching.builder()
                .memberId(memberId)
                .matchingName(matchingName)
                .level(level)
                .content(content)
                .address(address)
                .capacity(capacity)
                .category(category)
                .build();
    }

}
