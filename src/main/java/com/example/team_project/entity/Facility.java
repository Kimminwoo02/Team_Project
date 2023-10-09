package com.example.team_project.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor

public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facilityId;

    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "memberId")
    private Member member;


    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Float longitude;


    @Column(nullable = false)
    private Float altitude;

    @Builder
    public Facility(Member member,String name, String address, Float longitude, Float altitude){
        this.member = member;
        this.name = name;
        this.address = address;
        this.longitude = longitude;
        this.altitude = altitude;
    }

}
