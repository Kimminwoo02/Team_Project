package com.example.team_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.security.Principal;

@Entity
@NoArgsConstructor
@Getter


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
    private String nickName;

    private String phone;
    private String gender;
    private String memberRole;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private MemberImg memberImg;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    @Setter
    private Review review;

    @Builder
    public Member(String email, String password, String name, String phone, String gender ,String memberRole,String nickName){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.nickName = nickName;
        this.memberRole = memberRole;
    }

    public static Member createMember(String email, String password, String name, String phone, String gender ,String memberRole, String nickName){
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .gender(gender)
                .nickName(nickName)
                .memberRole(memberRole)
                .build();
    }





}
