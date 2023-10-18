package com.example.team_project.dto.matching;

import com.example.team_project.dto.comment.CommentDTO;
import com.example.team_project.entity.board.Comment;
import com.example.team_project.entity.member.Member;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MatchingMemberResponse {
    private Matching matching;
    private Member member;
    private String introduce;

    public static MatchingMemberResponse from(MatchingMember entity) {
        return new MatchingMemberResponse(
                entity.getMatching(),
                entity.getMember(),
                entity.getIntroduce()

        );
    }

}
