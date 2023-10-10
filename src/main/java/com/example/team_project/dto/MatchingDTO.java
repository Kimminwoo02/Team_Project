package com.example.team_project.dto;

import com.example.team_project.entity.Category;
import com.example.team_project.entity.Member;
import com.example.team_project.entity.Review;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MatchingDTO {
    private Long matchingId;
    private String matchingName;
    private List<MatchingMember> match;
    private Member member;
    private String level;
    private String content;
    private String address;

    private Category category;


    public Matching createMatching(String matchingName,List<MatchingMember> match,String level, String content,String address,Category category,Member member){
        return Matching.builder()
                .matchingName(matchingName)
                .match(match)
                .category(category)
                .level(level)
                .content(content)
                .address(address)
                .build();
    }

}
