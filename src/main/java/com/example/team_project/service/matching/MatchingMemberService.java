package com.example.team_project.service.matching;

import com.example.team_project.dto.matching.MatchingDTO;
import com.example.team_project.dto.matching.MatchingMemberDTO;
import com.example.team_project.dto.matching.MatchingMemberResponse;
import com.example.team_project.dto.matching.MatchingScheduleDTO;
import com.example.team_project.entity.member.Member;
import com.example.team_project.entity.matching.Matching;

import java.util.List;

public interface MatchingMemberService {
    void createAndAddMember2Matching(Long id);
    void addMember2Matching(MatchingMemberDTO matchingMemberDTO);

//    MatchingMemberResponse getMatchingMember(Long matchingId);

    List<MatchingMemberResponse> matchingApplyList(Long matchingId);

    List<MatchingMemberResponse> getMatching();
    List<MatchingDTO> getMyMatching();
    public List<MatchingScheduleDTO> getSchedule();

    public void applyDeny(String state, Long matchingUserId);
}
