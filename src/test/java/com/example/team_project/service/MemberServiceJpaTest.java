package com.example.team_project.service;

import com.example.team_project.config.MybatisConfig;
import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.entity.Member;
import com.example.team_project.repository.MemberRepository;
import groovy.util.logging.Log4j2;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@SpringBootTest
@Transactional
@ActiveProfiles
@Service
class MemberServiceJpaTest {
    @Autowired
    MemberServiceJpa memberServiceJpa;
    @Autowired MemberRepository memberRepository;



    @Test
    void 회원가입() throws Exception{
        //given
        SignupDto signupDto = SignupDto
                .builder()
                .email("a")
                .password("a")
                .email("a")
                .name("a")
                .phone("a")
                .gender("a")
                .nickName("a")
                .build();
        long count = memberRepository.count();
        memberServiceJpa.joinWithoutFile(signupDto);
        long count2 = memberRepository.count();

        Assertions.assertEquals(count,count2);

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