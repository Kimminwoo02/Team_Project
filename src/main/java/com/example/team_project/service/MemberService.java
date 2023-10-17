package com.example.team_project.service;

import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.dto.member.MemberSearchCond;
import com.example.team_project.dto.member.MemberInfoDTO;
import com.example.team_project.dto.member.MemberUpdateDto;
import com.example.team_project.entity.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public interface MemberService {
    void isDuplicateEmail(String nickname);
    SignupResponse join (SignupDto signupDto);
//    SignupResponse joinWithoutFile (SignupDto signupDto);
    MemberInfoDTO getLoginUserById(Long memberId);
     List<Member> findMembers();
     void validateDuplicateMember(String email);
     void update(MemberUpdateDto memberUpdateDto, Long memberId);
     Member getMemberId(MemberSearchCond memberSearchCond);

     Member getMember(Long memberId);

    HashMap<String, Object> usernameOverlap(String username);

     Long emailCheck(String email);

}
