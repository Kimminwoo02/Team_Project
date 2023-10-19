package com.example.team_project.repository;

import com.example.team_project.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByEmail(String email);
    Long countByEmail(String email);

    Member findByNameAndPhone(String name, String phone);

    Object existsByEmail(String email);


}
