package com.example.team_project.controller;

import com.example.team_project.dto.matching.MatchingDTO;
import com.example.team_project.dto.matching.MatchingMemberCreate;
import com.example.team_project.dto.matching.MatchingMemberResponse;
import com.example.team_project.entity.Category;
import com.example.team_project.entity.matching.MatchingMember;
import com.example.team_project.service.matching.MatchingMemberService;
import com.example.team_project.service.matching.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MatchingController {
    private final MatchingService matchingService;
    private final MatchingMemberService matchingMemberService;

    @GetMapping("/matching")
    public String matching(Model model){
        List<MatchingMember> matching = matchingMemberService.getMatching();
        model.addAttribute("categories",Category.values());
        model.addAttribute("matches", matching);
        return "main/matching";
    }

    @PostMapping("/matching")
    public String matching2(MatchingDTO matchingDTO){

        matchingService.createMatching(matchingDTO);
        matchingMemberService.createAndAddMember2Matching();
        return "redirect:/matching";
    }

    @PostMapping
    public String matchingMember(MatchingMemberCreate matchingMemberCreate){
        matchingMemberService.matchingApply(matchingMemberCreate.getMatching().getMemberId(), matchingMemberCreate.getMatching().getMatchingId(), matchingMemberCreate);

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

    @GetMapping("/matchingMemberList")
    public String matchingMemberList(){
        return "main/matchingMemberList";
    }
    @GetMapping("/matchingStatus")
    public String matchingStatus(){
        return "main/matchingStatus";
    }
    @GetMapping("/matchingApplyList")
    public String matchingApplyList(){
        return "main/matchingApplyList";
    }
}
