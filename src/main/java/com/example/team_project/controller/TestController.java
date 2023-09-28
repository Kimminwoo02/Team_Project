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
        return "home";
    }
    @GetMapping("/welcome")
    public String wel(){
        return "welcome";
    }

    @GetMapping("/facility")
    public String facilities(){
        return "facility";
    }


    @GetMapping("/matching")
    public String matching(){
        return "matching";
    }

    @GetMapping("/board")
    public String board(){
        return "board";
    }

    @GetMapping("/detail")
    public String detail(){
        return "detailBoard";
    }



}
