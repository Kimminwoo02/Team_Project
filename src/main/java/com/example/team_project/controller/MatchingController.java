package com.example.team_project.controller;

import com.example.team_project.dto.Response;
import com.example.team_project.dto.matching.MatchingDTO;
import com.example.team_project.dto.matching.MatchingMemberCreate;
import com.example.team_project.dto.matching.MatchingMemberResponse;
import com.example.team_project.entity.Category;
import com.example.team_project.entity.member.Member;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.member.MemberService;
import com.example.team_project.service.matching.MatchingMemberService;
import com.example.team_project.service.matching.MatchingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MatchingController {
    private final MatchingService matchingService;
    private final MatchingMemberService matchingMemberService;
    private final MemberService memberService;

    @GetMapping("/matching")
    public String matching(Model model){
        List<Matching> matches = matchingService.findAll();
        model.addAttribute("categories",Category.values());
        model.addAttribute("matches", matches);
        return "main/matching";
    }

    @PostMapping("/matching")
    public String matching2(MatchingDTO matchingDTO){
        matchingMemberService.createAndAddMember2Matching(matchingService.createMatching(matchingDTO));
        return "redirect:/matching";
    }

    @PostMapping("/matchingMember")
    @ResponseBody
    public Response<Void> matchingMember(@RequestBody MatchingMemberCreate matchingMemberCreate){
        Matching matching = matchingService.getMatching(matchingMemberCreate.getMatchingId());

        return Response.success();
    }
    @GetMapping("/matching/{cat}")
    public ModelAndView mat3(@PathVariable(name = "cat") String category){
       ModelAndView modelAndView = new ModelAndView("main/matching");
       modelAndView.addObject("matches",matchingService.findByCategory(Category.valueOf(category)));

        return modelAndView;
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
    public String matchingStatus(Model model){
        List<MatchingDTO> dto = matchingMemberService.getMyMatching();
        model.addAttribute("matchingList",dto);

        return "main/matchingStatus";
    }

//    @ResponseBody
//    @PostMapping("/matchingStatus")
//    public MatchingMemberResponse matchingAccpet(Long matchingUserId){
////        log.info(matchingMemberService.getMatchingMember(matchingUserId).toString() + "+++++ +++++" );
////        return matchingMemberService.getMatchingMember(matchingUserId);
//    }

    @GetMapping("/matchingApplyList/{matchingId}")
    public String matchingApplyList(Model model,@PathVariable Long matchingId) {
        System.out.println(matchingId);
        List<MatchingMemberResponse> matching = matchingMemberService.matchingApplyList(1L);

        log.info(matching.toString()+ " wrgaergsegserg");
        model.addAttribute("matchingList",matching);

        return "main/matchingApplyList";
    }
//    @PostMapping("/matchingApplyList")
//    public String m2(@RequestBody String matchingName){
//        return "redirect:";
//    }

    @PostMapping("/matchingApply/{matchingUserId}")
    @ResponseBody
    public String applyDeny(String state, @PathVariable Long matchingUserId) {
        matchingMemberService.applyDeny(state, matchingUserId);

        return "main/matchingApplyList";
    }


}
