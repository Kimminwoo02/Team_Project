package com.example.team_project.service.matching;

import com.example.team_project.dto.matching.MatchingDTO;
import com.example.team_project.entity.matching.Matching;

import java.util.List;

public interface MatchingService {

    void createMatching(MatchingDTO matchingDTO);

    List<Matching> findAll();

    Matching getMatching(Long matchingId);

}
