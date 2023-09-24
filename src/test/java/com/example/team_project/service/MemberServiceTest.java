package com.example.team_project.service;

import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.dto.member.MemberImgUploadDto;
import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.repository.MemberImgRepository;
import com.example.team_project.repository.MemberRepository;
import groovy.util.logging.Log4j2;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@Log4j2
@SpringBootTest

class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;



    @Test
    void 회원가입() throws Exception{
        //given
        SignupDto signupDtoImg = createSignupDtoImg();

        //when
        SignupResponse join = memberService.join(signupDtoImg);

        //then
        assertThat(join.getEmail()).isEqualTo(signupDtoImg.getEmail());
    }




    SignupDto createSignupDto(){
        return SignupDto.builder()
                .email("made_power@naver.com")
                .password("hello")
                .name("minu")
                .phone("010-1234-2345")
                .gender("male")
                .build();
    }

    SignupDto createSignupDtoImg(){
        MockMultipartFile file1 = new MockMultipartFile("file","filename-1.jpeg","image/jpeg","some-image".getBytes());

        SignupDto signupDto = createSignupDto();
        signupDto.setFile(file1);
        return signupDto;
    }

}