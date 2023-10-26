package com.example.team_project.dto.matching;

import com.example.team_project.entity.Category;
import com.example.team_project.entity.matching.Matching;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MatchingDTO {
    private Long matchingId;
    private Long masterId;
    private String matchingName;
    private String level;
    private String content;
    private String address;
    private String capacity;
    private Category category;
    private String sDate;

    public MatchingDTO(Long matchingId, Long masterId,String matchingName, String level, String content, String address, String capacity, Category category, String sDate) {
        this.matchingId = matchingId;
        this.masterId = masterId;
        this.matchingName = matchingName;
        this.level = level;
        this.content = content;
        this.address = address;
        this.capacity = capacity;
        this.category = category;
        this.sDate = sDate;
    }


    public static MatchingDTO from(Matching entity) {
        return new MatchingDTO(
                entity.getMatchingId(),
                entity.getMasterId(),
                entity.getMatchingName(),
                entity.getLevel(),
                entity.getContent(),
                entity.getAddress(),
                entity.getCapacity(),
                entity.getCategory(),
                entity.getSDate()
        );
    }





    public Matching createMatching(){
        return Matching.builder()
                .masterId(masterId)
                .matchingName(matchingName)
                .level(level)
                .content(content)
                .address(address)
                .sDate(sDate)
                .capacity(capacity)
                .category(category)
                .build();
    }

}
