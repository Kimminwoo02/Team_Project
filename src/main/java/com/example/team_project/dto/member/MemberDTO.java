package com.example.team_project.dto.member;

import com.example.team_project.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDTO {
        private String email;
        private String password;
        private String name;
        private String phone;
        private String gender;
        private String nickName;
        private String addr;
        private String detailAddr;
    public static MemberDTO fromEntity(Member entity){

        return new MemberDTO(
                entity.getEmail(),
                entity.getPassword(),
                entity.getName(),
                entity.getPhone(),
                entity.getGender(),
                entity.getNickName(),
                entity.getAddr(),
                entity.getDetailAddr()
        );
    }
}
