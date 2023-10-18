package com.example.team_project.repository;

import com.example.team_project.dto.matching.MatchingScheduleDTO;
import com.example.team_project.entity.matching.MatchingMember;
import com.example.team_project.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchingMemberRepository extends JpaRepository<MatchingMember,Long> {

        public List<MatchingMember> findAllByMemberEquals(Member member);

}
