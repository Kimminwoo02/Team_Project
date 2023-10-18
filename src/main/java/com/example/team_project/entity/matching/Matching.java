package com.example.team_project.entity.matching;

import com.example.team_project.entity.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class Matching {
    @Id
    @GeneratedValue
    private Long matchingId;

    @Setter
    private Long memberId;

    private String matchingName;

    private String level;

    private String content;

    private String address;

    private String capacity;

    private String sDate;

    @JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy = "matching", cascade = CascadeType.ALL)
    private List<MatchingMember> matchingMemberList;

    @Enumerated(EnumType.STRING)
    private Category category;


}
