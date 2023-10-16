package com.example.team_project.controller;

import com.example.team_project.dto.Board.BoardDTO;
import com.example.team_project.dto.comment.CommentDTO;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/save")
    public String save(@ModelAttribute CommentDTO commentDTO, @ModelAttribute BoardDTO boardDTO) {
        System.out.println("commentDTO = " + commentDTO);
        commentService.save(commentDTO);
        return "redirect:/board";

    }

    @PostMapping("/delete")
    public String delete(@AuthenticationPrincipal CustomUserDetails principal, CommentDTO commentDTO) {
        commentService.delete(commentDTO.getId(),principal.getName());
        return "redirect:/board";

    }



}
