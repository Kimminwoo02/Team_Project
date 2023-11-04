package com.example.team_project.service.board;

import com.example.team_project.dto.Board.BoardCreate;
import com.example.team_project.entity.member.Member;
import com.example.team_project.repository.BoardRepository;
import com.example.team_project.security.CustomUserDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Transactional
class BoardServiceJpaTest {


    @Mock
    private BoardRepository boardRepository;


    @Mock
    private CustomUserDetails principal;
    @InjectMocks
    private BoardServiceJpa boardService;

    @Test
    void 작성테스트() {

        // given

        // when

        // then
        Assertions.assertDoesNotThrow(()->boardService.write(boardCreate));
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void getBoardList() {
    }

    @Test
    void getBoard() {
    }

    @Test
    void getMyId() {
    }

    Member member = Member.builder()
            .email("이멜")
            .memberRole(null)
            .detailAddr("동작구 ")
            .phone("010-5018")
            .gender("남자")
            .nickName("asdfasdf")
            .addr("서울시")
            .password("1234123")
            .build();
    BoardCreate boardCreate =new BoardCreate("타이틀입니다.","내용입니다",member, null);


}