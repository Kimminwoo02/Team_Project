package com.example.team_project.controller;

import com.example.team_project.dto.MatchingDTO;
import com.example.team_project.entity.Category;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MatchingController {
    private final MatchingService matchingService;

    @GetMapping("/matching")
    public String matching(Model model){
        model.addAttribute("categories",Category.values());

        return "main/matching";
    }

    @PostMapping("/matching")
    public String matching2( MatchingDTO matchingDTO){
//        matchingDTO.setMatch();
        matchingService.createMatching(matchingDTO);
        return "redirect:/matching";
    }

}
