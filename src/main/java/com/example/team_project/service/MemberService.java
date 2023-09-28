package com.example.team_project.service;

import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.entity.Member;
import java.util.List;

public interface MemberService {
    void isDuplicateEmail(String nickname);
    SignupResponse join (SignupDto signupDto);
    void joinWithoutFile (SignupDto signupDto);
    Member getLoginUserById(Long memberId);
     List<Member> findMembers();
     void validateDuplicateMember(String email);
}
