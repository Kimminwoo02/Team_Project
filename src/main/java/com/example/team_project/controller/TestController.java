package com.example.team_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/loginPage")
    public String login(){
        return "loginPage";
    }
    @GetMapping("/findpw")
    public String findPw(){
        return "findpw";
    }
    @GetMapping("/findemail")
    public String findEmail(){
        return "findemailid";
    }


}
