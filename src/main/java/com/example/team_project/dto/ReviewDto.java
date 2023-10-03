package com.example.team_project.dto;

import com.example.team_project.entity.Member;
import com.example.team_project.entity.Review;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class ReviewDto {


    private int rating;
    private String content;
    private Member member;
    private Long memberId;



    public Review createReview(int rating, String content, Member member){
        return Review.builder()
                .rating(rating)
                .content(content)
                .member(member)
                .build();
    }
}





