package com.example.team_project.repository;

import com.example.team_project.dto.matching.MatchingDTO;
import com.example.team_project.entity.Category;
import com.example.team_project.entity.matching.Matching;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchingRepository extends JpaRepository<Matching,Long> {
    List<Matching> findByCategory(Category category);


    List<Matching> findAllByMasterId(Long id);
}
