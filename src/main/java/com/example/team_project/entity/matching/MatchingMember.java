package com.example.team_project.entity.matching;

import com.example.team_project.entity.Facility;
import com.example.team_project.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class MatchingMember {
    @Id
    @Column(name = "memberMatching_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchingUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matchingId")
    @Setter
    private Matching matching;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    @Setter
    private Member member;

    private Integer quota;

    private String introduce;

    private Boolean matchingYN;



    public MatchingMember(Long matchingUserId, Matching matching, Member member, Integer quota, Boolean matchingYN) {
        this.matchingUserId = matchingUserId;
        this.matching = matching;
        this.member = member;
        this.quota = quota;
        this.matchingYN = matchingYN;
    }

    public MatchingMember (Matching matching, String introduce, Member member){
        this.matching= matching;
        this.member = member;
        this.introduce= introduce;

    }
}
