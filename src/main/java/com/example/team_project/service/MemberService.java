package com.example.team_project.service;

import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.dto.member.Mail;
import com.example.team_project.dto.member.MemberSearchCond;
import com.example.team_project.dto.member.MemberInfoDTO;
import com.example.team_project.dto.member.MemberUpdateDto;
import com.example.team_project.entity.Member;
import java.util.List;

public interface MemberService {
    void isDuplicateEmail(String nickname);
    SignupResponse join (SignupDto signupDto);
    MemberInfoDTO getLoginUserById(Long memberId);
     List<Member> findMembers();
     void validateDuplicateMember(String email);
     void update(MemberUpdateDto memberUpdateDto, Long memberId);
     Member getMemberId(MemberSearchCond memberSearchCond);

}
