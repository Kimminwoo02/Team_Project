package com.example.team_project.controller;

import com.example.team_project.dto.ReviewDto;
import com.example.team_project.entity.Review;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.MemberServiceMybatis;
import com.example.team_project.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final ReviewService reviewService;

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



    @GetMapping("/matching")
    public String matching(){
        return "main/matching";
    }



    @PostMapping ("/review")
    public String review(ReviewDto reviewDto, @AuthenticationPrincipal CustomUserDetails principal) {
        reviewDto.setMember(principal.getMember());
        reviewService.addReview(reviewDto);
        return "redirect:/welcome";
    }

}
