package com.example.team_project.entity.matching;

import com.example.team_project.entity.AuditingFields;
import com.example.team_project.entity.Category;
import com.example.team_project.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Matching {
    @Id
    @GeneratedValue
    @Column(name = "matching_id")
    private Long matchingId;

    @Setter
    private Long memberId;

    private String matchingName;

    private String level;

    private String content;

    private String address;

    private String capacity;

    @OneToMany(mappedBy = "matching", cascade = CascadeType.ALL)
    private List<MatchingMember> matchingMemberList;

    @Enumerated(EnumType.STRING)
    private Category category;


}
