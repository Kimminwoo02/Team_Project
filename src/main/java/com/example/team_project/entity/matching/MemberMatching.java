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
public class MemberMatching {
    @Id
    @Column(name = "memberMatching_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchingUser_id;

    @ManyToOne
    @JoinColumn(name = "matchingId")
    private Matching matching;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

}
