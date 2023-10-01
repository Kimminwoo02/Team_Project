package com.example.team_project.security;

import com.example.team_project.entity.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




@Getter


public class CustomUserDetails extends User implements UserDetails  {

    private final String myName;
    private final Member member;
    private final String folderPath;
    private final String storeFileName;





    public CustomUserDetails(Member member, List<GrantedAuthority> authorities){
        super(member.getEmail(),member.getPassword(),authorities);
        this.myName = member.getName();
        this.member = member;
        this.folderPath = member.getMemberImg().getFolderPath();
        this.storeFileName = member.getMemberImg().getStoreFileName();
    }



    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getMemberRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getEmail();
    }

    public String getName() { return member.getName();}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
