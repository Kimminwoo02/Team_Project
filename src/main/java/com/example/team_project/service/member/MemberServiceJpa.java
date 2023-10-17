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
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final AuthenticationManager authenticationManager;

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




    public MemberInfoDTO getLoginUserById(Long memberId) {
        if(memberId == null) return null;
        Member optionalUser = memberRepository.findById(memberId).get();
        MemberImgDTO img = new MemberImgDTO(optionalUser.getMemberImg().getFolderPath(),optionalUser.getMemberImg().getStoreFileName());
        MemberInfoDTO member = new MemberInfoDTO(optionalUser.getMemberId(), optionalUser.getEmail(),
                optionalUser.getPassword(),optionalUser.getName(),optionalUser.getNickName(),
                optionalUser.getPhone(),optionalUser.getAddr(), optionalUser.getDetailAddr(),img);
        return member;
    }






    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public void validateDuplicateMember(String email){
        Member findMember = memberRepository.findByEmail(email);
        if (findMember != null){
            //throw new ApplicationException(ErrorCode.DUPLICATED_USER_MAIL, String.format("%s 는 이미 사용중인 메일입니다!", email));
        }
    }


    @Transactional
    @Override
    public void update(MemberUpdateDto memberUpdateDto, Long memberId) {
        Member member = memberRepository.getReferenceById(memberId);
        member.setPassword(passwordEncoder.encode(memberUpdateDto.getPassword()));
        member.setName(memberUpdateDto.getName());
        member.setNickName(memberUpdateDto.getNickName());
        member.setPhone(memberUpdateDto.getPhone());
        member.setAddr(memberUpdateDto.getAddr());
        member.setDetailAddr(memberUpdateDto.getDetailAddr());
        try{
            ResultFileStore resultFileStore = filestore.storeProfileFile(memberUpdateDto.getFile());
            MemberImg memberImg =memberImgRepository.getReferenceById(member.getMemberImg().getImgId());
            if(resultFileStore != null) {
                memberImg.setStoreFileName(resultFileStore.getStoreFileName());
            }
            memberImgRepository.save(memberImg);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
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

    @Override
    public Long emailCheck(String email) {
        return memberRepository.countByEmail(email);
    }



}
