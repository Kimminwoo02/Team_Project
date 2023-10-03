package com.example.team_project.service;


import com.example.team_project.dto.ReviewDto;
import com.example.team_project.entity.Review;

import java.util.List;

public interface ReviewService {
    public void addReview(ReviewDto review);

    public List<Review> review();
}
