package com.example.team_project.controller;

import com.example.team_project.dto.Board.BoardDTO;
import com.example.team_project.dto.Response;
import com.example.team_project.dto.comment.CommentDTO;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;


    @PostMapping("/write")
    @ResponseBody
    public String save( CommentDTO commentDTO, Model model) {
        model.addAttribute("comment",commentDTO);
        commentService.save(commentDTO);

        return "redirect:/boardRead/{commentDTO.boardId}";
    }


    @PostMapping("/delete")
    public String delete(@AuthenticationPrincipal CustomUserDetails principal, CommentDTO commentDTO) {
        commentService.delete(commentDTO.getId(),principal.getName());
        return "redirect:/board";

    }



}
