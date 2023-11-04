package com.example.team_project.service;

import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.service.member.MemberServiceJpa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@Transactional
class MemberServiceJpaTest {
    @Mock
    private MemberRepository memberRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private MemberServiceJpa memberService;




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