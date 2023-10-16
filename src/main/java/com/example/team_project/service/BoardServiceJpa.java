package com.example.team_project.service;

import com.example.team_project.dto.Board.BoardCreate;
import com.example.team_project.dto.Board.BoardDTO;
import com.example.team_project.dto.Board.BoardUpdate;
import com.example.team_project.entity.Board;
import com.example.team_project.entity.Category;
import com.example.team_project.entity.Member;
import com.example.team_project.repository.BoardRepository;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.security.CustomUserDetails;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@Service
public class BoardServiceJpa implements BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void write(BoardCreate boardCreate) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member member = ((CustomUserDetails)principal).getMember();
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
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Member member = ((CustomUserDetails) principal).getMember();
         board.setTitle(boardUpdate.getTitle());
         board.setContent(boardUpdate.getContent());

    }

    @Override
    public List<BoardDTO> getBoardList() {
        List<Board> findAll = boardRepository.findAll();
        List<BoardDTO> allPost = new ArrayList<>();

        for(Board board : findAll){
            BoardDTO build = BoardDTO.builder()
                    .boardId(board.getBoardId())
                    .content(board.getContent())
                    .title(board.getTitle())
                    .build();

            allPost.add(build);
        }
        return allPost;
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
}
