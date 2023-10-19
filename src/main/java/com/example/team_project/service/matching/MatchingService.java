package com.example.team_project.service.matching;

import com.example.team_project.dto.matching.MatchingDTO;
import com.example.team_project.entity.Category;
import com.example.team_project.entity.matching.Matching;

import java.util.List;

public interface MatchingService {

    Long createMatching(MatchingDTO matchingDTO);

    List<Matching> findAll();

    List<Matching> findByCategory(Category category);

    Matching getMatching(Long matchingId);

}
