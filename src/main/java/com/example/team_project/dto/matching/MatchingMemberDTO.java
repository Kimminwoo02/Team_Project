package com.example.team_project.dto.matching;

import com.example.team_project.entity.member.Member;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class MatchingMemberDTO {
    private Long matchingMemberId;
    private Matching matching;
    private Long applierId;
    private Member member;
    private Integer quota;
    private String introduce;
    private Boolean matchingYN = false;





    public static  MatchingMemberDTO from (MatchingMember entity) {
        return new MatchingMemberDTO(
                entity.getMatchingMemberId(),
                entity.getMatching(),
                entity.getApplierId(),
                entity.getMember(),
                entity.getQuota(),
                entity.getIntroduce(),
                entity.getMatchingYN()
        );

    }
}
