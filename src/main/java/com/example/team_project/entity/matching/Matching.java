package com.example.team_project.entity.matching;

import com.example.team_project.entity.AuditingFields;
import com.example.team_project.entity.Category;
import com.example.team_project.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
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

    @OneToMany(mappedBy = "matching", cascade = CascadeType.ALL)
    private List<MatchingMember> matchingMemberList;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Builder
    public Matching(Long memberId,
                    String matchingName,
                    String level,
                    String content,
                    String address,
                    Category category) {
        this.memberId = memberId;
        this.matchingName = matchingName;
        this.level = level;
        this.content = content;
        this.address = address;
        this.category = category;
    }

}
