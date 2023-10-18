package com.example.team_project.dto.matching;

import com.example.team_project.entity.matching.MatchingMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchingScheduleDTO {
    private Long matchingId;
    private String title;
    private String date;

    public static MatchingScheduleDTO from(MatchingMember entity){
            System.out.println("&&&&&&&&&&&&&&&&&"+entity.getMatching().getMatchingName());
            return new MatchingScheduleDTO(
                    entity.getMatching().getMatchingId(),
                    entity.getMatching().getMatchingName(),
                    entity.getSDate()
            );
    }
}
