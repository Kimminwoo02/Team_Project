package com.example.team_project.service.member;

import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.dto.member.MemberSearchCond;
import com.example.team_project.entity.Member;
import com.example.team_project.entity.MemberImg;
import com.example.team_project.exception.ApplicationException;
import com.example.team_project.exception.ErrorCode;
import com.example.team_project.file.FileStore;
import com.example.team_project.file.ResultFileStore;
import com.example.team_project.repository.MemberImgRepository;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


@RequiredArgsConstructor
@Log4j2
@Service
public class MemberServiceJpa implements MemberService {
    @Value("${IMAGES}")
    private  String imagePath;


    private final MemberRepository memberRepository;
    private final MemberImgRepository memberImgRepository;
    private final PasswordEncoder passwordEncoder;
    private final FileStore filestore;

    @Transactional
    public void isDuplicateEmail(String nickname){
        validateDuplicateMember(nickname);
    }


    @Transactional
    public SignupResponse join (SignupDto signupDto) {


        Member member = signupDto.toMemberEntity();

        isDuplicateEmail(member.getEmail());
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        Member memberEntity = memberRepository.save(member);

        try{
            MemberImg memberImgEntity = null;
            ResultFileStore resultFileStore = filestore.storeProfileFile(signupDto.getFile());
            MemberImg memberImg;
            if(resultFileStore== null){
                memberImg = signupDto.toMemberImgEntity(imagePath, "cat.jpg",member);
            }else{
                memberImg = signupDto.toMemberImgEntity(resultFileStore.getFolderPath(), resultFileStore.getStoreFileName(),member);
            }
            memberImgEntity = memberImgRepository.save(memberImg);
            return new SignupResponse(memberEntity,memberImgEntity);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    public Member getLoginUserById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow
                (() -> new ApplicationException(ErrorCode.USER_NOT_FOUND));
    }


    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public void validateDuplicateMember(String email){
        Member findMember = memberRepository.findByEmail(email);
        if (findMember != null){
            throw new ApplicationException(ErrorCode.DUPLICATED_USER_MAIL, String.format("%s 는 이미 사용중인 메일입니다!", email));
        }
    }

    @Override
    public Member getMemberId(MemberSearchCond memberSearchCond) {
        return memberRepository.findByNameAndPhone(memberSearchCond.getName(),memberSearchCond.getPhone());
    }


    public HashMap<String, Object> usernameOverlap(String email) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", memberRepository.existsByEmail(email));
        return map;
    }


}
