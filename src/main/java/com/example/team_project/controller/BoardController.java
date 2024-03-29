package com.example.team_project.controller;


import com.example.team_project.dto.Board.BoardCreate;
import com.example.team_project.dto.Board.BoardDTO;
import com.example.team_project.dto.Board.BoardUpdate;
import com.example.team_project.entity.Category;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.PaginationService;
import com.example.team_project.service.board.BoardServiceJpa;
import com.example.team_project.service.comment.CommentService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class BoardController {
    private final BoardServiceJpa boardServiceJpa;
    private final CommentService commentService;
    private final PaginationService paginationService;

    @GetMapping("/boardMain")
    public String board(Model model) {
        model.addAttribute("categories", Category.values());

        return "main/board";
    }


    @GetMapping("/detail")
    public String boardlist(Model model) {
        List<BoardDTO> boardList = boardServiceJpa.getBoardList();
        model.addAttribute("boardList", boardList);
        model.addAttribute("categories",Category.values());

        return "main/detailBoard";
    }

    @GetMapping("/boardRead")
    public String read(Long boardId, ModelMap model ,Pageable pageable) {

        BoardDTO board = boardServiceJpa.getBoard(boardId);
        model.addAttribute("board", board);
        model.addAttribute("categories", Category.values());
        model.addAttribute("boardId", boardId);
        model.addAttribute("comments", commentService.getComment(boardId,pageable));

        return "main/boardRead";
    }

    @GetMapping("/boardWrite")
    public String write1(Model model) {
        model.addAttribute("categories",Category.values());
        return "main/boardWrite";
    }

    @PostMapping("/boardWrite")
    public String write2(BoardCreate boardCreate) {
        boardServiceJpa.write(boardCreate);
        return "redirect:/detail";
    }

    @GetMapping("/board")
    public String update1(Long boardId, Model model) {
        BoardDTO board = boardServiceJpa.getBoard(boardId);
        model.addAttribute("board", board);
        return "main/boardUpdate";
    }

    @PutMapping("/board/{boardId}")
    public String update2(@ModelAttribute BoardUpdate boardUpdate, @PathVariable Long boardId) {
        boardServiceJpa.update(boardUpdate, boardId);

        return "redirect:/detail";
    }

    @DeleteMapping("/board/{boardId}")
    public String delete(@PathVariable("boardId") Long boardId) {
        boardServiceJpa.delete(boardId);
        return "redirect:/detail";
    }


}
