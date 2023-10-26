package com.example.team_project.entity.matching;

import com.example.team_project.entity.AuditingFields;
import com.example.team_project.entity.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class Matching extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long matchingId;

    @Setter
    private Long masterId;

    private String matchingName;

    private String level;

    private String content;

    private String address;

    private String capacity;

    private String sDate;

    @JsonIgnore
    @OneToMany(mappedBy = "matching", cascade = CascadeType.ALL)
    private List<MatchingMember> matchingMember = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Category category;


}
