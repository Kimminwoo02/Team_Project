package com.example.team_project.entity;

import jakarta.persistence.*;

@Entity
public class Member  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255)
    private String email;

    private String password;

    private String name;

    private String phone;
    private String address;
    private int gender;
}
