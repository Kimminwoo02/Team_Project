package com.example.team_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Review extends AuditingFields {
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
        this.rating = rating;
        this.content = content;
        this.member = member;

    }


}
