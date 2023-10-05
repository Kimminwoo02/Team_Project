package com.example.team_project.repository;

import com.example.team_project.dto.member.MemberSearchCond;
import com.example.team_project.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByEmail(String email);



}
