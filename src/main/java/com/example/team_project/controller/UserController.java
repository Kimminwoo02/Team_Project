package com.example.team_project.controller;

import com.example.team_project.dto.CMResponseDto;
import com.example.team_project.dto.auth.SigninDto;
import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.dto.member.MemberImgUploadDto;
import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.entity.Member;
import com.example.team_project.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "loginPage";
    }

    @GetMapping("/findpw")
    public String findPw(){
        return "findpw";
    }
    @GetMapping("/findemail")
    public String findEmail(){
        return "findemailid";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signup1(@ModelAttribute SignupDto signupDto) throws IOException {
        log.info(String.valueOf(signupDto));
        memberService.join(signupDto);
        return "redirect:/home";

    }


}
