package com.example.team_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {



    @GetMapping("/home")
    public String Test2(){
        return "home";
    }

    @GetMapping("/facility")
    public String facilities(){
        return "facility";
    }


    @GetMapping("/matching")
    public String matching(){
        return "matching";
    }




}
