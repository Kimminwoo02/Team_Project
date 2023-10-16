package com.example.team_project.dto.auth;

import com.example.team_project.dto.member.MemberImgDTO;
import com.example.team_project.entity.Member;
import com.example.team_project.entity.MemberImg;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SignupResponse {
    private Long id;
    private String email;
    private String name;
    private MemberImgDTO file;

    public SignupResponse(Member member, MemberImg memberImg){
        this.id = member.getMemberId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.file = MemberImgDTO.builder()
                    .folderPath(memberImg.getFolderPath())
                    .storeFileName(memberImg.getStoreFileName())
                    .build();
        }

    public SignupResponse(Member member){
        this.id = member.getMemberId();
        this.email = member.getEmail();
        this.name = member.getName();
    }
}
