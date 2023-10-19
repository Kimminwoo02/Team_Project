package com.example.team_project.dto;

import com.example.team_project.entity.member.Member;
import com.example.team_project.entity.member.Review;
import lombok.*;

@Getter
@Setter
public class ReviewDto {


    private int rating;
    private String content;
    private Long memberId;
    private Member member;



    public Review createReview(int rating, String content,Member member){
        return Review.builder()
                .rating(rating)
                .content(content)
                .member(member)
                .build();
    }
}





