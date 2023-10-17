package com.example.team_project.service;

import com.example.team_project.dto.matching.MatchingMemberDTO;

public interface MatchingMemberService {
    void createAndAddMember2Matching();
    void addMember2Matching(MatchingMemberDTO matchingMemberDTO);

}
