package com.example.team_project.service;

import com.example.team_project.dto.article.CreateArticle;
import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.entity.Member;

import java.util.List;

public interface ArticleService {
    void  write (CreateArticle createArticle);



//
//    void joinWithoutFile (SignupDto signupDto);
//    Member getLoginUserById(Long memberId);
//    List<Member> findMembers();
//    void validateDuplicateMember(String email);
}
