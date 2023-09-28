package com.example.team_project.repository;

import com.example.team_project.entity.MemberImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberImgRepository extends JpaRepository<MemberImg,Long> {
}
