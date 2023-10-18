package com.example.team_project.dto.auth;

import com.example.team_project.entity.member.Member;
import com.example.team_project.entity.member.MemberImg;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@ToString
public class SignupDto {

    private String email;

    private String password;

    private String name;

    private String phone;

    private String gender;
    private String nickName;

    private String addr;
    private String detailAddr;

    private MultipartFile file;

    public Member toMemberEntity(){
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .gender(gender)
                .nickName(nickName)
                .addr(addr)
                .detailAddr(detailAddr)
                .build();

    }

    public MemberImg toMemberImgEntity(String folderPath, String storeFileName, Member member){
        return MemberImg.builder()
                .member(member)
                .folderPath(folderPath)
                .storeFileName(storeFileName)
                .build();
    }

}
