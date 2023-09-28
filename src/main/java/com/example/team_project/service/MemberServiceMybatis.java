package com.example.team_project.service;

import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.dto.member.MemberSearchCond;
import com.example.team_project.entity.Member;
import com.example.team_project.entity.MemberImg;
import com.example.team_project.file.FileStore;
import com.example.team_project.file.ResultFileStore;
import com.example.team_project.repository.MemberImgRepository;
import com.example.team_project.repository.MemberRepositoryMybatis;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MemberServiceMybatis implements MemberService {
    private final PasswordEncoder passwordEncoder;
    private final FileStore filestore;
    private final MemberRepositoryMybatis memberRepositoryMybatis;
    private final MemberImgRepository memberImgRepository;


    @Transactional
    public void isDuplicateEmail(String nickname){
        validateDuplicateMember(nickname);
    }


    @Transactional
    public SignupResponse join (SignupDto signupDto) {

        Member member = signupDto.toMemberEntity();

        isDuplicateEmail(member.getName());
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberRepositoryMybatis.saveWithoutFileMybatis(member);

        try{
            MemberImg memberImgEntity = null;
            ResultFileStore resultFileStore = filestore.storeProfileFile(signupDto.getFile());
            MemberImg memberImg = signupDto.toMemberImgEntity(resultFileStore.getFolderPath(), resultFileStore.getStoreFileName(),member);
            memberImgEntity = memberImgRepository.save(memberImg);
            return new SignupResponse();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    @Transactional
    public void joinWithoutFile (SignupDto signupDto)  {
        Member member = signupDto.toMemberEntity();
        isDuplicateEmail(member.getEmail());
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberRepositoryMybatis.saveWithoutFileMybatis(member);
    }



    public Member getLoginUserById(Long memberId) {
        if(memberId == null) return null;

        Optional<Member> optionalUser = memberRepositoryMybatis.findByIdMybatis(memberId);
        return optionalUser.orElse(null);

    }

    @Override
    public List<Member> findMembers() {
        return null;
    }


    public List<Member> findMembers(MemberSearchCond memberSearchCond){
        return memberRepositoryMybatis.findAllMybatis(memberSearchCond);
    }

    public void validateDuplicateMember(String email){
        Optional<Member> findMember = memberRepositoryMybatis.findByEmailMybatis(email);
        if (findMember.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
