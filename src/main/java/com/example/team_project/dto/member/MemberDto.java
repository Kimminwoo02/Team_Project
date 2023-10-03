package com.example.team_project.dto.member;

import com.example.team_project.entity.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private Long memberId;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String gender;
    private String memberRole;
}


