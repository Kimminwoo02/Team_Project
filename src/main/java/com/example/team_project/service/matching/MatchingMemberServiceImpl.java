package com.example.team_project.service.matching;

import com.example.team_project.dto.matching.MatchingMemberDTO;
import com.example.team_project.dto.matching.MatchingMemberResponse;
import com.example.team_project.dto.matching.MatchingScheduleDTO;
import com.example.team_project.entity.member.Member;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import com.example.team_project.repository.MatchingMemberRepository;
import com.example.team_project.repository.MatchingRepository;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.security.CustomUserDetails;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

@RequiredArgsConstructor
@Service
public class MatchingMemberServiceImpl implements MatchingMemberService {
    private final MemberRepository memberRepository;
    private final MatchingRepository matchingRepository;
    private final MatchingMemberRepository matchingMemberRepository;

    @Override
    public void createAndAddMember2Matching() {
        Member member = memberRepository.getReferenceById(getMyId());
        Matching matching = matchingRepository.getReferenceById(getMyId());

        matching.setMemberId(getMyId());

        MatchingMember matchingMember = new MatchingMember();
        matchingMember.setMatching(matching);
        matchingMember.setMember(member);
        matchingMember.setSDate(matching.getSDate());

        matchingMemberRepository.save(matchingMember);
    }

    @Override
    public void addMember2Matching(MatchingMemberDTO matchingMemberDTO) {
        Member member = memberRepository.getReferenceById(getMyId());
        Matching matching = matchingRepository.getReferenceById(getMyId());
        matching.setMemberId(getMyId());
        // TODO /* 일단 지금 MM entity는 멤버와 1:N, 근데 MM entity PK로 조회 때려서 여러 member 가져오는 거 */


        MatchingMember matchingMember = matchingMemberRepository.getReferenceById(matchingMemberDTO.getMatchingUserId());
    }

    @Override
    public void matchingApply(Member member, Matching matching, String introduce) {

    }

    @Override
    public List<MatchingMemberResponse> getMatching() {
        List<MatchingMember> matchingMembers = matchingMemberRepository.findAll();

        return matchingMembers.stream().map(MatchingMemberResponse::from )
                .collect(Collectors.toList());
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



    @Override
    @Transactional
    public List<MatchingScheduleDTO> getSchedule(){
        Member member = memberRepository.getReferenceById(getMyId());
        List<MatchingMember> list = matchingMemberRepository.findAllByMemberEquals(member);

        return list.stream()
                .map(MatchingScheduleDTO::from)
                .collect(Collectors.toList());
    }


    public static Long getMyId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((CustomUserDetails) principal).getMember().getMemberId();
    }
}
