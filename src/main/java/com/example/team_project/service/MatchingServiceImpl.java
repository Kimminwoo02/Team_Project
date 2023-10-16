//package com.example.team_project.service;
//
//import com.example.team_project.dto.MatchingDTO;
//
//import com.example.team_project.entity.matching.Matching;
//import com.example.team_project.repository.MatchingMemberRepository;
//import com.example.team_project.repository.MatchingRepository;
//import com.example.team_project.repository.MemberRepository;
//import com.example.team_project.security.CustomUserDetails;
//import com.fasterxml.jackson.databind.deser.DataFormatReaders;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.security.Principal;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class MatchingServiceImpl implements MatchingService {
//    private final MemberRepository memberRepository;
//    private final MatchingRepository matchingRepository;
//    private final MatchingMemberRepository matchingMemberRepository;
//
//    // 매칭 등록
//    @Override
//    public void createMatching(MatchingDTO matchingDTO) {
//        System.out.println(matchingDTO.getCategory()+"=====================");
//        // transform DTO to Entity
//        Matching matching = matchingDTO.createMatching();
//
//        // get Authenticated logged-in object in session
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        // casting logged-in object to member and get PK from entity(named Member)
//        // Class CustomUserDetails contains object member type Member to get own PK.
//        Long memberId = ((CustomUserDetails) principal).getMember().getMemberId();
//        matching.setMemberId(memberId);
//
//        matchingRepository.save(matching);
////        Member와 N:M으로 통신하지 않기 위해
//
//    }
//
//        // 매칭 맴버 등록
//    @Override
//    public List<Matching> findAll() {
//        return matchingRepository.findAll();
//    }
//}

import com.example.team_project.dto.MatchingDTO;

import com.example.team_project.entity.matching.Matching;
import com.example.team_project.repository.MatchingMemberRepository;
import com.example.team_project.repository.MatchingRepository;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.security.CustomUserDetails;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MatchingServiceImpl implements MatchingService {
    private final MemberRepository memberRepository;
    private final MatchingRepository matchingRepository;
    private final MatchingMemberRepository matchingMemberRepository;

    // 매칭 등록
    @Override
    public void createMatching(MatchingDTO matchingDTO) {
        System.out.println(matchingDTO.getCategory()+"=====================");
        // transform DTO to Entity
        Matching matching = matchingDTO.createMatching();

        // get Authenticated logged-in object in session
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // casting logged-in object to member and get PK from entity(named Member)
        // Class CustomUserDetails contains object member type Member to get own PK.
        Long memberId = ((CustomUserDetails) principal).getMember().getMemberId();
        matching.setMemberId(memberId);

        matchingRepository.save(matching);
//        Member와 N:M으로 통신하지 않기 위해

    }

        // 매칭 맴버 등록
    @Override
    public List<Matching> findAll() {
        return matchingRepository.findAll();
    }
}
