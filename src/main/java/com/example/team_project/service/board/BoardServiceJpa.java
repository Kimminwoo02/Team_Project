package com.example.team_project.service.board;

import com.example.team_project.dto.Board.BoardCreate;
import com.example.team_project.dto.Board.BoardDTO;
import com.example.team_project.dto.Board.BoardUpdate;
import com.example.team_project.entity.board.Board;
import com.example.team_project.entity.member.Member;
import com.example.team_project.repository.BoardRepository;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.security.CustomUserDetails;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log4j2
@Service
public class BoardServiceJpa implements BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void write(BoardCreate boardCreate) {
        Member member = memberRepository.getReferenceById(getMyId());
        boardCreate.setMember(member);
        boardRepository.save(boardCreate.toBoardEntity());

    }

    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Transactional
    @Override
    public void update(BoardUpdate boardUpdate,Long boardId) {
        Board board = boardRepository.getReferenceById(boardId);
        board.setTitle(boardUpdate.getTitle());
         board.setContent(boardUpdate.getContent());

    }

    @Override
    public List<BoardDTO> getBoardList() {
        List<Board> findAll = boardRepository.findAll();

        return findAll.stream()
                .map(m -> new BoardDTO(m.getBoardId(),m.getContent(),m.getTitle()))
                .collect(Collectors.toList());

    }



    @Override
    public BoardDTO getBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).get();

        return BoardDTO.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .content(board.getContent())
                .member(board.getMember())
                .build();
    }


    public static Long  getMyId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((CustomUserDetails) principal).getMember().getMemberId();
    }
}
