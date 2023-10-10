package com.example.team_project.service;

import com.example.team_project.dto.MatchingDTO;
import com.example.team_project.entity.Member;

import com.example.team_project.entity.matching.Matching;
import com.example.team_project.repository.MatchingRepository;
import com.example.team_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchingServiceImpl implements MatchingService{
    private final MemberRepository memberRepository;
    private final MatchingRepository matchingRepository;
    @Override
    public void createMatching(MatchingDTO matchingDTO) {
        Member target = memberRepository.getReferenceById(matchingDTO.getMember().getMemberId());

//        Member와 N:M으로 통신하지 않기 위해
//        matchingDTO.getMatch().stream().filter(m->m.getMember().getMemberId())
        matchingRepository.save(matchingDTO.createMatching(
                matchingDTO.getMatchingName(),matchingDTO.getMatch().stream()
                        .filter(member-> Objects.equals(member.getMember().getMemberId(), target.getMemberId()))
                        .collect(Collectors.toList()),matchingDTO.getLevel(),matchingDTO.getContent(), matchingDTO.getAddress(), matchingDTO.getCategory(),matchingDTO.getMember()));
    }

    @Override
    public List<Matching> findAll() {
        return matchingRepository.findAll();
    }
}
