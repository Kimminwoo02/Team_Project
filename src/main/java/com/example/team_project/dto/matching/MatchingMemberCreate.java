package com.example.team_project.dto.matching;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MatchingMemberCreate {

    private Long matchingId;
    private Long memberId;
    private String introduce;


}
