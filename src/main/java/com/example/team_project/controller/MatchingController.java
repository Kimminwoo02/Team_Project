package com.example.team_project.controller;

import com.example.team_project.dto.matching.MatchingDTO;
import com.example.team_project.entity.Category;
import com.example.team_project.service.MatchingMemberService;
import com.example.team_project.service.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MatchingController {
    private final MatchingService matchingService;
    private final MatchingMemberService matchingMemberService;


    @GetMapping("/matching")
    public String matching(Model model){
        model.addAttribute("categories",Category.values());

        return "main/matching";
    }

    @PostMapping("/matching")
    public String matching2(MatchingDTO matchingDTO){
//        matchingDTO.setMatch();

        matchingService.createMatching(matchingDTO);
        matchingMemberService.createAndAddMember2Matching();
        return "redirect:/matching";
    }

    @GetMapping("/matching/{Category}")
    public String mat3(@PathVariable String Category){
        return "redirect:/matching";
    }

    @GetMapping("/matchingHistory")
    public String history(){
        return "main/matchingHistory";
    }
}
