package com.example.team_project.controller;

import com.example.team_project.dto.member.MemberImgDTO;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.MemberServiceMybatis;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {




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



    @GetMapping("/detail")
    public String detail(){
        return "main/detailBoard";
    }


}
