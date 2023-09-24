package com.example.team_project.dto.auth;

import com.example.team_project.entity.Member;
import com.example.team_project.entity.MemberImg;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@ToString
public class SignupDto {

    @NotEmpty(message = "이메일 입력은 필수입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$",message="이메일 형식에 맞지 않습니다.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력값입니다.")
    private String password;

    @NotEmpty(message = "이름을 입력해주세요")
    private String name;

    private String phone;

    private String gender;

    private MultipartFile file;

    public Member toMemberEntity(){
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .gender(gender)
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
