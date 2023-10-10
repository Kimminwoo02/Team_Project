package com.example.team_project.service;

import com.example.team_project.dto.MatchingDTO;
import com.example.team_project.dto.member.MemberDto;
import com.example.team_project.entity.Member;
import com.example.team_project.entity.matching.Matching;

public interface MatchingMemberService {
    void addMatching(MatchingDTO matching, MemberDto member);

}
