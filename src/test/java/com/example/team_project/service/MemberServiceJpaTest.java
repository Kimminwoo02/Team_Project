package com.example.team_project.service;

import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.service.member.MemberServiceJpa;
import groovy.util.logging.Log4j2;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@Log4j2
@SpringBootTest

class MemberServiceJpaTest {
    @Autowired
    MemberServiceJpa memberServiceJpa;
    @Autowired MemberRepository memberRepository;



    @Test
    void 회원가입() throws Exception{
        //given
        SignupDto signupDtoImg = createSignupDtoImg();

        //when
        SignupResponse join = memberServiceJpa.join(signupDtoImg);

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