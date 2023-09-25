package com.example.team_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.security.Principal;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long memberId;
    @Column(length = 255, nullable = false)
    private String email;

    @Column(nullable = false)
    @Setter
    private String password;

    private String name;

    private String phone;
    private String gender;
    private String memberRole;



}
