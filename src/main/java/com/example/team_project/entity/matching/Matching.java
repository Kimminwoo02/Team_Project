package com.example.team_project.entity.matching;

import com.example.team_project.entity.AuditingFields;
import com.example.team_project.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Matching extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matching_id")
    private Long matchingId;

    @Setter
    private String matchingName;

    @OneToMany(mappedBy = "matching", cascade = CascadeType.ALL)
    private List<MemberMatching> memberMatchingList;

    @OneToMany(mappedBy = "matching", cascade = CascadeType.ALL)
    private List<MatchingMessanger> matchingMessangerList;

    @OneToOne(mappedBy = "categoryId", cascade = CascadeType.ALL)
    private Category category;

}
