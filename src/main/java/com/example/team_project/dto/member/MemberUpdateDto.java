package com.example.team_project.dto.member;

import com.example.team_project.entity.member.Member;
import com.example.team_project.entity.member.MemberImg;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberUpdateDto {
    private String email;
    private String password;
    private String name;
    private String nickName;
    private String phone;
    private String addr;
    private String detailAddr;
    private MultipartFile file;

    public MemberImg toMemberImgEntity(String folderPath, String storeFileName, Member member){
        return MemberImg.builder()
                .member(member)
                .folderPath(folderPath)
                .storeFileName(storeFileName)
                .build();
    }

}
