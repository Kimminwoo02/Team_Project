package com.example.team_project.controller;


import com.example.team_project.dto.matching.MatchingScheduleDTO;
import com.example.team_project.service.matching.MatchingMemberService;
import com.example.team_project.service.matching.MatchingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CalendarController {
    private final MatchingMemberService matchingMemberService;

    @GetMapping("/mySchedule")
    public String getschedule(Model model){
         List<MatchingScheduleDTO> list = matchingMemberService.getSchedule();
         model.addAttribute("result",list);
        return "main/mySchedule";
    }


}
