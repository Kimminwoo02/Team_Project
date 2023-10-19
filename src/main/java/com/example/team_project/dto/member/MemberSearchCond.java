package com.example.team_project.dto.member;

import lombok.Data;

@Data
public class MemberSearchCond {
    String name;
    String phone;
    String email;

    public MemberSearchCond(String name, String phone){
        this.name = name;
        this.phone=phone;
    }

}
