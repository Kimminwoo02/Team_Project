package com.example.team_project.controller;

import com.example.team_project.service.MemberServiceMybatis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final MemberServiceMybatis memberServiceMybatis;



    @GetMapping("/home")
    public String home(Model model){
        List<Review> reviews = reviewService.review();
        model.addAttribute("review",reviews);
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


    @GetMapping("/write")
    public String write() {
        return "main/boardWrite";

    }

    @PostMapping("/review")
    public String review(ReviewDto reviewDto, @AuthenticationPrincipal CustomUserDetails principal) {
        reviewDto.setMember(principal.getMember());
        reviewService.addReview(reviewDto);
        return "redirect:/welcome";
    }
}
