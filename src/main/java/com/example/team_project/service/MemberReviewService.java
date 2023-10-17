package com.example.team_project.service;

import com.example.team_project.entity.Member;
import com.example.team_project.entity.MemberReview;
import com.example.team_project.repository.MemberReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberReviewService {

    @Autowired
    private MemberReviewRepository memberReviewRepository;

    public MemberReview createReview(MemberReview review) {
        return memberReviewRepository.save(review);
    }

    public Optional<MemberReview> getReviewById(Long id) {
        return memberReviewRepository.findById(id);
    }

    public List<MemberReview> getAllReviews() {
        return memberReviewRepository.findAll();
    }


    public MemberReview updateReview(MemberReview review) {
        return memberReviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        memberReviewRepository.deleteById(id);
    }
}
