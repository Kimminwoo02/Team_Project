package com.example.team_project.repository;

import com.example.team_project.entity.member.MemberImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberImgRepository extends JpaRepository<MemberImg,Long> {
}
