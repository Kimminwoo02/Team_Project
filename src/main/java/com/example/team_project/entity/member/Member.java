package com.example.team_project.entity.member;

import com.example.team_project.entity.board.Board;
import com.example.team_project.entity.matching.MatchingMember;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    @Column(length = 255, nullable = false)
    private String email;

    @Column(nullable = false)
    @Setter
    private String password;

    @Setter
    private String name;
    @Setter
    private String nickName;
    @Setter
    private String phone;
    private String gender;

    private String memberRole;
    @Setter
    private String addr;
    @Setter
    private String detailAddr;
    @Setter
    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private MemberImg memberImg;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    @Setter
    private Review review;

    @JsonBackReference
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Board> board = new ArrayList<>();

    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "member", cascade  = CascadeType.ALL)
    private List<MatchingMember> memberMatchingList = new ArrayList<>();

    @OneToMany(mappedBy = "reviewedMember", cascade  = CascadeType.ALL)
    private List<MemberReview> receivedReviews = new ArrayList<>();


    public double getAverageRatingFromMembers() {
        return receivedReviews.stream()
                .mapToInt(MemberReview::getRating)
                .average()
                .orElse(0.0);
    }

    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)
    private List<MemberReview> writtenReviews = new ArrayList<>();

    @Builder
    public Member(String email, String password, String name, String phone, String gender, String nickName, String addr, String detailAddr, String memberRole) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.nickName = nickName;
        this.addr = addr;
        this.detailAddr=detailAddr;
        this.memberRole = memberRole;
    }








}
