package com.example.team_project.repository;

import com.example.team_project.entity.MemberImg;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchingMemberRepository extends JpaRepository<MatchingMember,Long> {
}
