package com.example.team_project.repository;

import com.example.team_project.dto.ReviewDto;
import com.example.team_project.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findTop6ByOrderByCreatedAt();
}
