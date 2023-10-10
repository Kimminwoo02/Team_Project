package com.example.team_project.entity.matching;

import com.example.team_project.entity.AuditingFields;
import com.example.team_project.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter

public class MatchingMessanger extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchingMessanger_id")
    private Long matchingMessangerId;

    @ManyToOne
    @JoinColumn(name = "matchingId")
    private Matching matching;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

}
