package com.example.team_project.controller;

import com.example.team_project.dto.Response;
import com.example.team_project.dto.article.CreateArticle;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/board")
    public String board(){
        return "main/board";
    }


    @GetMapping("/detail")
    public String detail(){
        return "main/detailBoard";
    }


    @GetMapping("/write")
    public String write() {
        return "main/boardWrite";

    }

    @ResponseBody
    @PostMapping("/write")
    public String writeArticle(CreateArticle createArticle, @AuthenticationPrincipal CustomUserDetails principal) {
        createArticle.setMember(principal.getMember());
        articleService.write(createArticle);
        return "redirect:/detail";

    }
}
