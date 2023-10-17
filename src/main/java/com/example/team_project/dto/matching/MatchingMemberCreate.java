package com.example.team_project.dto.matching;

import com.example.team_project.entity.Member;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter

public class MatchingMemberCreate {

    private Long matchingId;
    private Long memberId;
    private String introduce;


}
