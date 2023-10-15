package com.example.team_project.service.member;

import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.dto.member.MemberSearchCond;
import com.example.team_project.entity.Member;
import com.example.team_project.entity.MemberImg;
import com.example.team_project.file.FileStore;
import com.example.team_project.file.ResultFileStore;
import com.example.team_project.repository.MemberImgRepository;
import com.example.team_project.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Log4j2
@Service
public class MemberServiceJpa implements MemberService {
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

        isDuplicateEmail(member.getName());
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        Member memberEntity = memberRepository.save(member);

        try{
            MemberImg memberImgEntity = null;
            ResultFileStore resultFileStore = filestore.storeProfileFile(signupDto.getFile());
            MemberImg memberImg = signupDto.toMemberImgEntity(resultFileStore.getFolderPath(), resultFileStore.getStoreFileName(),member);
            memberImgEntity = memberImgRepository.save(memberImg);
            return new SignupResponse(memberEntity,memberImgEntity);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    @Transactional
    public void joinWithoutFile (SignupDto signupDto)  {

        Member member = signupDto.toMemberEntity();

        isDuplicateEmail(member.getName());
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        Member memberEntity = memberRepository.save(member);

        new SignupResponse(memberEntity);

    }



    public Member getLoginUserById(Long memberId) {
        if(memberId == null) return null;

        Optional<Member> optionalUser = memberRepository.findById(memberId);
        return optionalUser.orElse(null);

    }







    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public void validateDuplicateMember(String email){
        Member findMember = memberRepository.findByEmail(email);
        if (findMember != null){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Override
    public Member getMemberId(MemberSearchCond memberSearchCond) {
        return memberRepository.findByNameAndPhone(memberSearchCond.getName(),memberSearchCond.getPhone());
    }

}
