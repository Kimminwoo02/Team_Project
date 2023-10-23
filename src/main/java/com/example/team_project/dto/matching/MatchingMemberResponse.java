package com.example.team_project.dto.matching;

import com.example.team_project.dto.comment.CommentDTO;
import com.example.team_project.entity.board.Comment;
import com.example.team_project.entity.member.Member;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MatchingMemberResponse {
    private Long matchingMemberId;
    private Matching matching;
    private Member member;
    private String introduce;

    public static MatchingMemberResponse from(MatchingMember entity) {
        return new MatchingMemberResponse(
                entity.getMatchingMemberId(),
                entity.getMatching(),
                entity.getMember(),
                entity.getIntroduce()

        );
    }

}
