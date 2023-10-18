package com.example.team_project.controller;

import com.example.team_project.dto.Response;
import com.example.team_project.dto.facility.CreateFacility;
import com.example.team_project.service.facility.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Response<Void> getFacilities(CreateFacility createFacility ){
        facilityService.save(createFacility);

        return Response.success();
    }


}
