package com.example.team_project.dto.member;

import lombok.Data;
@Data
public class MemberUpdateDto {
    private String email;
    private String password;
    private String name;
    private String phone;
}
