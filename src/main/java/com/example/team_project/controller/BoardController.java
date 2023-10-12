package com.example.team_project.controller;


import com.example.team_project.dto.Board.BoardCreate;
import com.example.team_project.dto.Board.BoardDTO;
import com.example.team_project.dto.Board.BoardUpdate;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.BoardService;
import com.example.team_project.service.BoardServiceJpa;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class BoardController {
    private final BoardServiceJpa boardServiceJpa;

    @GetMapping("/boardMain")
    public String board(){
        return "main/board";
    }


    @GetMapping("/detail")
    public String boardlist(Model model){
        List<BoardDTO> boardList = boardServiceJpa.getBoardList();
        model.addAttribute("boardList", boardList);
        return "main/detailBoard";
    }

    @GetMapping("/boardRead")
    public String read(Long boardId, Model model){
        BoardDTO board = boardServiceJpa.getBoard(boardId);
        model.addAttribute("board", board);
        return "main/boardRead";
    }

    @GetMapping("/boardWrite")
    public String write1(){

        return "main/boardWrite";
    }

    @PostMapping("/boardWrite")
    public String write2(@RequestParam String title,@RequestParam String content, @AuthenticationPrincipal CustomUserDetails principal){
        System.out.println(title+" ######################### "+content);
        BoardCreate boardCreate = new BoardCreate(title, content.substring(1), principal.getMember());
        boardServiceJpa.write(boardCreate);

        return "redirect:/detail";
    }

    @GetMapping("/board")
    public String update1(Long boardId, Model model, @AuthenticationPrincipal CustomUserDetails principal){
        System.out.println(boardId);
        BoardDTO board = boardServiceJpa.getBoard(boardId);
        model.addAttribute("board",board);
    return "main/boardUpdate";
    }

    @PutMapping("/board")
    public String update2(@RequestParam String title,@RequestParam String content, Long boardId, @AuthenticationPrincipal CustomUserDetails principal) {
        BoardUpdate boardUpdate = new BoardUpdate(title, content);
        boardServiceJpa.update(boardUpdate, boardId, principal.getMember().getMemberId());

        return "redirect:/detail";
    }

    @DeleteMapping("/board/{boardId}")
    public String delete(@PathVariable Long boardId){
        BoardDTO board = boardServiceJpa.getBoard(boardId);
        boardServiceJpa.delete(boardId);
        boardServiceJpa.delete(boardId);
        return "redirect:/detail";
    }


}
