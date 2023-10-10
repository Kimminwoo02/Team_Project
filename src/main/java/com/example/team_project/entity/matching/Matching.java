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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matching_id")
    private Long matchingId;


    private String matchingName;

    private String level;

    private String content;

    private String address;



    @OneToMany(mappedBy = "matching", cascade = CascadeType.ALL)
    private List<MatchingMember> match;


    private Category category;

    @Builder
    public Matching(String matchingName,String level,List<MatchingMember> match,String content,String address, Category category){
        this.matchingName = matchingName;
        this.level = level;
        this.content = content;
        this.match = match;
        this.address = address;
        this.category = category;

    }

}
