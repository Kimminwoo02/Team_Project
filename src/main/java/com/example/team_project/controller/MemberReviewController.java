package com.example.team_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.team_project.entity.MemberReview;
import com.example.team_project.service.MemberReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reviews")
public class MemberReviewController {

    @Autowired
    private MemberReviewService memberReviewService;


    @GetMapping("/add")
    public String showAddReviewForm(Model model) {
        model.addAttribute("review", new MemberReview());
        return "add-review";
    }

    @PostMapping
    public String createReview(@ModelAttribute MemberReview review) {
        memberReviewService.createReview(review);
        return "redirect:/reviews";
    }

    @GetMapping("/{id}")
    public Optional<MemberReview> getReviewById(@PathVariable Long id) {
       return memberReviewService.getReviewById(id);
    }


    @GetMapping
    public String getAllReviews(Model model) {
        List<MemberReview> reviews = memberReviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "reviews";
    }

    @PutMapping
    public MemberReview updateReview(@RequestBody MemberReview review) {
        return memberReviewService.updateReview(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        memberReviewService.deleteReview(id);
    }

}
