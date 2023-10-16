package com.example.team_project.entity.matching;

import com.example.team_project.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Setter
    private Matching matching;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    @Setter
    private Member member;

    private Integer quota;

    private Boolean matchingYN;

}
