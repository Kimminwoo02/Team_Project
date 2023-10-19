package com.example.team_project.controller;

import com.example.team_project.Response.CommentResponse;
import com.example.team_project.dto.Board.BoardDTO;
import com.example.team_project.dto.Response;
import com.example.team_project.dto.comment.CommentDTO;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.PaginationService;
import com.example.team_project.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    private final PaginationService paginationService;


    @PostMapping("/write")
    @ResponseBody
    public CommentResponse save(CommentDTO commentDTO) {
        commentService.save(commentDTO);
        return new CommentResponse(commentDTO.getCommentWriter(), commentDTO.getMemberId(),commentDTO.getCommentContents());
    }



    @PostMapping("/delete")
    public String delete(CommentDTO commentDTO) {
        commentService.delete(commentDTO.getId());
        return "redirect:/board";

    }

    //댓글 조회

    @GetMapping("/list")
    public String getComments(Model model, CommentDTO commentDTO) {
        Pageable pageable = PageRequest.of(0, 10);
        List<CommentDTO> comments = commentService.getComment(commentDTO.getBoardId(), pageable);
        model.addAttribute("comments", comments);

        return "commentList";  // 댓글 리스트를 보여주는 뷰 이름
    }



}
