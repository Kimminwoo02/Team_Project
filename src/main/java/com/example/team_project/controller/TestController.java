package com.example.team_project.controller;

import com.example.team_project.service.MemberServiceMybatis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final MemberServiceMybatis memberServiceMybatis;


    @GetMapping("/home")
    public String Test2(){
        return "main/home";
    }
    @GetMapping("/welcome")
    public String wel(){
        return "main/welcome";
    }

    @GetMapping("/facility")
    public String facilities(){
        return "main/facility";
    }


    @GetMapping("/matching")
    public String matching(){
        return "main/matching";
    }

    @GetMapping("/board")
    public String board(){
        return "main/board";
    }

    @GetMapping("/chat")
    public String chat(){
        return "main/chat";
    }

    @GetMapping("/detail")
    public String detail(){
        return "main/detailBoard";
    }



}
