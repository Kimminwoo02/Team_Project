package com.example.team_project.repository;

import com.example.team_project.entity.member.MemberReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberReviewRepository extends JpaRepository<MemberReview, Long> {
}
