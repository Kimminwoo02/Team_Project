package com.example.team_project.service.review;

import com.example.team_project.dto.ReviewDto;

import com.example.team_project.entity.member.Member;
import com.example.team_project.entity.member.Review;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    public void addReview(ReviewDto reviewDto) {
       Member member = memberRepository.getReferenceById(reviewDto.getMemberId());
       reviewRepository.save(reviewDto.createReview(reviewDto.getRating(), reviewDto.getContent(),member));
    }

    @Override
    public List<Review> review() {
        return reviewRepository.findTop6ByOrderByCreatedAt();
    }
}