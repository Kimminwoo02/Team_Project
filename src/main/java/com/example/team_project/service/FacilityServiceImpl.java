package com.example.team_project.service;

import com.example.team_project.dto.facility.CreateFacility;
import com.example.team_project.entity.Facility;
import com.example.team_project.entity.Member;
import com.example.team_project.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {
    private final FacilityRepository facilityRepository;

    @Override
    public void save(CreateFacility createFacility) {
        Member member = createFacility.getMember();
        Facility facility = createFacility.toCreateFacility();
        facility.setMember(member);
        facilityRepository.save(facility);
    }
}
