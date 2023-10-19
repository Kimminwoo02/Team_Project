package com.example.team_project.entity.matching;

import com.example.team_project.entity.member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matchingId")
    @Setter
    private Matching matching;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    @Setter
    private Member member;

    private Integer quota = 0;

    private String introduce;
    @Setter
    private Boolean matchingYN;
    @Setter
    private String sDate;



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

    public void AcceptMatch () {
        this.quota += 1;
    }
}
