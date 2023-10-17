package com.example.team_project.dto.matching;

import com.example.team_project.entity.Member;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import lombok.Data;

@Data
public class MatchingMemberResponse {
    private Matching matching;
    private Member member;
    private String introduce;


    public MatchingMember toMatchingMember(){
        return MatchingMember.builder()
                .matching(matching)
                .member(member)
                .introduce(introduce)
                .build();
    }

}
