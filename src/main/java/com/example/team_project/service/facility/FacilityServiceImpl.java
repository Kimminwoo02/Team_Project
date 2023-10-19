package com.example.team_project.service.facility;

import com.example.team_project.dto.facility.CreateFacility;
import com.example.team_project.entity.Facility;
import com.example.team_project.repository.FacilityRepository;
import com.example.team_project.security.CustomUserDetails;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
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
