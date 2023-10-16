package com.example.team_project.service.member;

import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.dto.auth.SignupResponse;
import com.example.team_project.dto.member.MemberImgDTO;
import com.example.team_project.dto.member.MemberInfoDTO;
import com.example.team_project.dto.member.MemberSearchCond;
import com.example.team_project.dto.member.MemberUpdateDto;
import com.example.team_project.entity.Member;
import com.example.team_project.entity.MemberImg;
import com.example.team_project.file.FileStore;
import com.example.team_project.file.ResultFileStore;
import com.example.team_project.repository.MemberImgRepository;
import com.example.team_project.repository.MemberRepositoryMybatis;

import com.example.team_project.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
//    @Transactional
//    public void joinWithoutFile (SignupDto signupDto)  {
//        Member member = signupDto.toMemberEntity();
//        isDuplicateEmail(member.getEmail());
//        member.setPassword(passwordEncoder.encode(member.getPassword()));
//        memberRepositoryMybatis.saveWithoutFileMybatis(member);
//    }



    public MemberInfoDTO getLoginUserById(Long memberId) {
        if(memberId == null) return null;

        Member optionalUser = memberRepositoryMybatis.findByIdMybatis(memberId).get();
        MemberImgDTO img = new MemberImgDTO(optionalUser.getMemberImg().getFolderPath(),optionalUser.getMemberImg().getStoreFileName());
        MemberInfoDTO member = new MemberInfoDTO(optionalUser.getMemberId(), optionalUser.getEmail(),
                optionalUser.getPassword(),optionalUser.getName(),optionalUser.getNickName(),
                optionalUser.getPhone(),optionalUser.getAddr(),optionalUser.getDetailAddr(),img);
        return member;

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

    @Override
    public void update(MemberUpdateDto memberUpdateDto, Long memberId) {

    }

    @Override
    public Member getMemberId(MemberSearchCond memberSearchCond) {
        Member member = new Member();
        return member;
    }

    @Override
    public HashMap<String, Object> usernameOverlap(String username) {
        return new HashMap<>();

    }

    @Override
    public Long emailCheck(String email) {
        return 0L;
    }

}
