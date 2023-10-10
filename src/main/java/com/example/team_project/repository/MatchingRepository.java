package com.example.team_project.repository;

import com.example.team_project.entity.matching.Matching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchingRepository extends JpaRepository<Matching,Long> {

}
