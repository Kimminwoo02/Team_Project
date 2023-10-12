package com.example.team_project.dto.facility;

import com.example.team_project.entity.Facility;
import com.example.team_project.entity.Member;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFacility {

    private String address;
    private String name;
    private Float longitude;
    private Float altitude;

    public Facility toFacility(){
        return Facility.builder()
                .address(address)
                .name(name)
                .longitude(longitude)
                .altitude(altitude)
                .build();

    }

}
