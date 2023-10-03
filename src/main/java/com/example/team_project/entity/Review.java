package com.example.team_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor

public class Review  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;
    private int rating;
    private String content;

    @OneToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @Builder
    public Review(int rating, String content, Member member){
        super();
        this.rating = rating;
        this.content = content;
        this.member = member;

    }

    public static Review CreateReview(int rating, String content,Member member){
        return Review.builder()
                .rating(rating)
                .content(content)
                .member(member)
                .build();
    }
}
