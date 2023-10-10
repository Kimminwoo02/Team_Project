package com.example.team_project.service;

import com.example.team_project.dto.MatchingDTO;
import com.example.team_project.dto.member.MemberDto;
import com.example.team_project.entity.matching.Matching;

import java.util.List;

public interface MatchingService {

    void createMatching(MatchingDTO matchingDTO);

    List<Matching> findAll();

}