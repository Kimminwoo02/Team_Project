package com.example.team_project.dto.member;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class MemberInfoDTO {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickName;
    private String phone;
    private String addr;
    private String detailAddr;
    private MemberImgDTO file;


}
