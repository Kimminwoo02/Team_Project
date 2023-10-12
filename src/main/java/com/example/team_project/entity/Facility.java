package com.example.team_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@NoArgsConstructor
@Builder
@Getter
@AllArgsConstructor
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facilityId;

//    @Setter
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "memberId")
//    private Member member;

    @Setter private Long memberId;

    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Float longitude;


    @Column(nullable = false)
    private Float altitude;

   public static Facility of(Long memberId, String address, String name, Float longitude, Float altitude){
       return  Facility.builder()
               .memberId(memberId)
               .address(address)
               .name(name)
               .longitude(longitude)
               .altitude(altitude)
               .build();
   }

}
