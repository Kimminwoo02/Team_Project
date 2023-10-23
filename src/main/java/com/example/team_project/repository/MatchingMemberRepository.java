package com.example.team_project.repository;

import com.example.team_project.dto.matching.MatchingDTO;
import com.example.team_project.dto.matching.MatchingMemberDTO;
import com.example.team_project.dto.matching.MatchingMemberResponse;
import com.example.team_project.dto.matching.MatchingScheduleDTO;
import com.example.team_project.dto.member.MemberDTO;
import com.example.team_project.entity.board.Board;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import com.example.team_project.entity.member.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchingMemberRepository extends JpaRepository<MatchingMember,Long> {


        @EntityGraph(attributePaths = {"member"})
        List<MatchingMember> findAllByMember_MemberId(Long  memberId);

        @EntityGraph(attributePaths = {"member"})
        List<MatchingMemberResponse> findAllByMatching_MatchingId(Long MatchingId);
}
