package com.example.team_project.service;

import com.example.team_project.dto.facility.CreateFacility;
import com.example.team_project.entity.Facility;
import com.example.team_project.entity.Member;
import com.example.team_project.repository.FacilityRepository;
import com.example.team_project.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {
    private final FacilityRepository facilityRepository;

    @Override
    public void save(CreateFacility createFacility) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long memberId = ((CustomUserDetails) principal).getMember().getMemberId();
        Facility facility = createFacility.toFacility();
        facility.setMemberId(memberId);
        facilityRepository.save(facility);

    }
}
