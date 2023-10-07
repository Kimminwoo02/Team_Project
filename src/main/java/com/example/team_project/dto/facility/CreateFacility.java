package com.example.team_project.dto.facility;

import com.example.team_project.entity.Facility;
import com.example.team_project.entity.Member;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreateFacility {
    private Member member;
    private String address;
    private String name;
    private Float longitude;
    private Float altitude;


    public Facility toCreateFacility(){
        return Facility.builder()
                .member(member)
                .name(name)
                .address(address)
                .longitude(longitude)
                .altitude(altitude)
                .build();
    }
}
