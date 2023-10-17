package com.example.team_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MemberReview {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String content;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Member reviewer; //리뷰를 작성한 회원

    @ManyToOne
    @JoinColumn(name = "reviewed_member_id")
    private Member reviewedMember;
}
