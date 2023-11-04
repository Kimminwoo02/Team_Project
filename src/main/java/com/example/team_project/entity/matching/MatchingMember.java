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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchingMemberId;

    @Setter
    private Long applierId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matchingId")
    @Setter
    private Matching matching;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    @Setter
    private Member member;


    private Integer quota = 0;
    @Setter
    private String introduce;
    @Setter
    private Boolean matchingYN = null;
    private Boolean reviewYN = null;
    @Setter
    private String sDate;



    public MatchingMember(Long matchingMemberId, Matching matching, Member member, Integer quota, Boolean matchingYN) {
        this.matchingMemberId = matchingMemberId;
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
