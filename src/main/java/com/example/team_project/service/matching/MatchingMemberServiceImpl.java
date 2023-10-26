package com.example.team_project.service.matching;

import com.example.team_project.dto.matching.MatchingDTO;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class MatchingMemberServiceImpl implements MatchingMemberService {
    private final MemberRepository memberRepository;
    private final MatchingRepository matchingRepository;
    private final MatchingMemberRepository matchingMemberRepository;



    @Override
    public void createAndAddMember2Matching(Long id) {
        Member member = memberRepository.getReferenceById(getMyId());
        Matching matching=matchingRepository.getReferenceById(id);
        matching.setMasterId(getMyId());

        MatchingMember matchingMember = new MatchingMember();
        matchingMember.setMatching(matching);
        matchingMember.setMember(member);
        matchingMember.setSDate(matching.getSDate());

        matchingMemberRepository.save(matchingMember);
    }

    @Override
    public void addMember2Matching(MatchingMemberDTO matchingMemberDTO) {
        Member member = memberRepository.getReferenceById(getMyId());
        Matching matching = matchingRepository.getReferenceById(matchingMemberDTO.getMatching().getMatchingId());

        matching.setMasterId(member.getMemberId());

        MatchingMember matchingMember = new MatchingMember();
        matchingMember.setMatching(matching);
        matchingMember.setMember(member);
        matchingMemberRepository.save(matchingMember);

    }

    @Override
    public List<MatchingMemberDTO> matchingApplyList(Long matchingId) {

        return matchingMemberRepository.findAllByMatching_MatchingIdAndMatchingYNIsNull(matchingId).stream()
                .map(MatchingMemberDTO::from)
                .toList();
    }

    @Override
    public List<MatchingMemberResponse> getMatching() {
        List<MatchingMember> matchingMembers = matchingMemberRepository.findAll();

        return matchingMembers.stream().map(MatchingMemberResponse::from)
                .collect(Collectors.toList());
    }




    @Override
    @Transactional
    public List<MatchingScheduleDTO> getSchedule(){

        List<MatchingMember> list = matchingMemberRepository.findAllByMember_MemberIdAndMatchingYNIsFalse(getMyId());

        return list.stream()
                .map(MatchingScheduleDTO::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<MatchingMemberDTO> getHistory() {
        return matchingMemberRepository.findAllByMember_MemberIdAndMatchingYNTrue(getMyId()).stream()
                .map(MatchingMemberDTO::from)
                .collect(Collectors.toList());

    }

    @Override
    public void updateMatching(Long matchingMemberId) {
        log.info("ccxcxcxcxcxcxc" + matchingMemberId );
        MatchingMember matchingMember = matchingMemberRepository.findByMatchingMemberId(matchingMemberId);
        matchingMember.setMatchingYN(true);

    }

    @Override
    public void applyDeny(String state, Long matchingUserId) {
        MatchingMember matchingMember = matchingMemberRepository.getReferenceById(matchingUserId);
        if(state=="false"){
            matchingMember.setMatchingYN(false);
        }else if(state=="true"){
            matchingMember.setMatchingYN(true);
        }

    }

    public static Long getMyId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((CustomUserDetails) principal).getMember().getMemberId();
    }
}
