package com.example.team_project.controller;

import com.example.team_project.dto.Response;
import com.example.team_project.dto.facility.CreateFacility;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class FacilityController {
    private final FacilityService facilityService;

    @GetMapping("/facility")
    public String facilities(){
        return "main/facility";
    }

    @ResponseBody
    @PostMapping("/facility")
    public Response<Void> getfacilities(CreateFacility createFacility, @AuthenticationPrincipal CustomUserDetails principal ){
        createFacility.setMember(principal.getMember());
        facilityService.save(createFacility);

        return Response.success();
    }


}
