package com.example.team_project.dto.matching;

import com.example.team_project.entity.member.Member;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MatchingMemberDTO {
    private Long matchingUserId;
    private Matching matching;
    private Member member;
    private Integer quota;
    private Boolean matchingYN;


    public MatchingMember createMatchingMember() {
        return MatchingMember.builder()
                .matchingUserId(matchingUserId)
                .matching(matching)
                .member(member)
                .quota(quota)
                .matchingYN(matchingYN)
                .build();
    }
}
