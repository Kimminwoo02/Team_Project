package com.example.team_project.dto.member;

import com.example.team_project.entity.Member;
import com.example.team_project.entity.MemberImg;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MemberImgUploadDto {
    private MultipartFile file;

    public MemberImg toEntity(String memberImgUrl, Member member){
        return MemberImg.builder()
                .member(member)
                .storeFileName(memberImgUrl)
                .build();
    }

}
