package com.example.team_project.entity.matching;

import com.example.team_project.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class MatchingMember {
    @Id
    @Column(name = "memberMatching_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchingUser_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matchingId")
    private Matching matching;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    private Integer quota;

    private Boolean matchingYN;

    public void addMatching(Matching matching){
        this.matching = matching;
    }

    public void addMember(Member member){
        this.member = member;
    }

}
