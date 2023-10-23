package com.example.team_project.service.matching;

import com.example.team_project.dto.matching.MatchingDTO;
import com.example.team_project.dto.matching.MatchingMemberDTO;
import com.example.team_project.dto.matching.MatchingMemberResponse;
import com.example.team_project.dto.matching.MatchingScheduleDTO;
import com.example.team_project.dto.member.MemberDTO;
import com.example.team_project.entity.Category;
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

//    @Override
//    public List<MatchingMember> findAll() {
//        return matchingMemberRepository.findAll();
//    }

//    @Override
//    public MatchingMember findMatchingMemberByMatching_MatchingId(Long matchingIdOfMatchingWannaFind) {
//        return matchingMemberRepository.findMatchingMemberByMatching_MatchingId(matchingIdOfMatchingWannaFind);
//    }

    @Override
    public void createAndAddMember2Matching(Long id) {
        Member member = memberRepository.getReferenceById(getMyId());
        Matching matching=matchingRepository.getReferenceById(id);
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
        Matching matching = matchingRepository.getReferenceById(matchingMemberDTO.getMatching().getMatchingId());

        matching.setMemberId(member.getMemberId());

        MatchingMember matchingMember = new MatchingMember();
        matchingMember.setMatching(matching);
        matchingMember.setMember(member);
        matchingMemberRepository.save(matchingMember);

    }

    @Override
    public List<MatchingMemberResponse> matchingApplyList(Long matchingId) {
//        Matching matching = matchingRepository.getReferenceById(matchingId);
        log.info("" + matchingMemberRepository.findAllByMatching_MatchingId(1L));
        return matchingMemberRepository.findAllByMatching_MatchingId(matchingId).stream()
                .map(m ->  new MatchingMemberResponse(m.getMatchingMemberId(),m.getMatching(),m.getMember(),m.getIntroduce()))
                .toList();
    }

    @Override
    public List<MatchingMemberResponse> getMatching() {
        List<MatchingMember> matchingMembers = matchingMemberRepository.findAll();

        return matchingMembers.stream().map(MatchingMemberResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<MatchingDTO> getMyMatching() {
//        Member member = memberRepository.getReferenceById(getMyId());
//        MemberDTO memberDTO = MemberDTO.fromEntity(member);
        List<MatchingMember> myMatchingList = matchingMemberRepository.findAllByMember_MemberId(getMyId());

        return myMatchingList.stream()
                .map(m -> new MatchingDTO(m.getMatching().getMatchingId(), m.getMatching().getMatchingName(), m.getMatching().getLevel(), m.getMatching().getContent(), m.getMatching().getAddress(), m.getMatching().getCapacity(), m.getMatching().getCategory(), m.getMatching().getSDate()))
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
//        Member member = memberRepository.getReferenceById(getMyId());
//        MemberDTO memberDTO = MemberDTO.fromEntity(member);
        List<MatchingMember> list = matchingMemberRepository.findAllByMember_MemberId(getMyId());

        return list.stream()
                .map(MatchingScheduleDTO::from)
                .collect(Collectors.toList());
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
