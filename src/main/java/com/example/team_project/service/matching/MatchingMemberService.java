package com.example.team_project.service.matching;

import com.example.team_project.dto.matching.MatchingMemberCreate;
import com.example.team_project.dto.matching.MatchingMemberDTO;
import com.example.team_project.dto.matching.MatchingMemberResponse;
import com.example.team_project.entity.Member;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;

import java.util.List;

public interface MatchingMemberService {
    void createAndAddMember2Matching();
    void addMember2Matching(MatchingMemberDTO matchingMemberDTO);


//    MatchingMemberResponse getMatchingMember(Long matchingId);


    void matchingApply(Member member, Matching matching, String introduce);

    List<MatchingMember> getMatching();

}
