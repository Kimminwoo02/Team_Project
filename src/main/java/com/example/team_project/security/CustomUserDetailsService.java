package com.example.team_project.security;

import com.example.team_project.entity.member.Member;
import com.example.team_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Member member = memberRepository.findByEmail(email);
        if(member == null){
            throw new  UsernameNotFoundException("해당 유저를 찾을 수 없습니다.");
        }

        return new CustomUserDetails(member,authorities);

    }
}
