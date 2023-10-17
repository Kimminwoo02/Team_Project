package com.example.team_project.service.matching;

import com.example.team_project.dto.matching.MatchingMemberCreate;
import com.example.team_project.dto.matching.MatchingMemberDTO;
import com.example.team_project.dto.matching.MatchingMemberResponse;
import com.example.team_project.entity.Member;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import com.example.team_project.repository.MatchingMemberRepository;
import com.example.team_project.repository.MatchingRepository;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MatchingMemberServiceImpl implements MatchingMemberService {
    private final MemberRepository memberRepository;
    private final MatchingRepository matchingRepository;
    private final MatchingMemberRepository matchingMemberRepository;

    @Override
    public void createAndAddMember2Matching() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long memberId = ((CustomUserDetails) principal).getMember().getMemberId();
        Member member = memberRepository.getReferenceById(memberId);
        Matching matching = matchingRepository.getReferenceById(memberId);

        matching.setMemberId(memberId);

        MatchingMember matchingMember = new MatchingMember();
        matchingMember.setMatching(matching);
        matchingMember.setMember(member);

        matchingMemberRepository.save(matchingMember);
    }

    @Override
    public void addMember2Matching(MatchingMemberDTO matchingMemberDTO) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long memberId = ((CustomUserDetails) principal).getMember().getMemberId();
        Member member = memberRepository.getReferenceById(memberId);
        Matching matching = matchingRepository.getReferenceById(memberId);
        matching.setMemberId(memberId);
        // TODO /* 일단 지금 MM entity는 멤버와 1:N, 근데 MM entity PK로 조회 때려서 여러 member 가져오는 거 */


        MatchingMember matchingMember = matchingMemberRepository.getReferenceById(matchingMemberDTO.getMatchingUserId());
    }

    @Override
    public void matchingApply(Member member, Matching matching, String introduce) {

    }


    @Override
    public List<MatchingMember> getMatching() {
        return matchingMemberRepository.findAll();
    }

//    @Override
//    public MatchingMemberResponse getMatchingMember(Long matchingId) {
////        matchin
////        MatchingMember matchingMember = matchingMemberRepository.getReferenceById(matchingMemberId);
//
//        MatchingMemberResponse matchingMemberResponse = new MatchingMemberResponse();
//        matchingMemberResponse.setMatching(matchingMember.getMatching());
//        matchingMemberResponse.setMember(matchingMember.getMember());
//        matchingMemberResponse.setIntroduce(matchingMember.getIntroduce());
//
//        return matchingMemberResponse;


}
