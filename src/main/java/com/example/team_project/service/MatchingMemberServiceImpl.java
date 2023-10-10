package com.example.team_project.service;

import com.example.team_project.dto.MatchingDTO;
import com.example.team_project.dto.member.MemberDto;
import com.example.team_project.entity.Member;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import com.example.team_project.repository.MatchingMemberRepository;
import com.example.team_project.repository.MatchingRepository;
import com.example.team_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MatchingMemberServiceImpl implements MatchingMemberService {
    private final MemberRepository memberRepository;
    private final MatchingRepository matchingRepository;
    private final MatchingMemberRepository matchingMemberRepository;

    @Override 
    public void addMatching(MatchingDTO matchingDto, MemberDto memberDto) {
        Member member = memberRepository.getReferenceById(memberDto.getMemberId());
        Matching matched = matchingRepository.getReferenceById(matchingDto.getMatchingId());

        MatchingMember matchingMember = new MatchingMember();
        matchingMember.addMatching(matched);
        matchingMember.addMember(member);

    }
}
