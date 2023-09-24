package com.example.team_project.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token =( UsernamePasswordAuthenticationToken) authentication;

        String email = token.getName();
        String password = (String)token.getCredentials();

        CustomUserDetails dbUser = (CustomUserDetails) userDetailsService.loadUserByUsername(email);

        if(!passwordEncoder.matches(password,dbUser.getPassword())){
            throw new BadCredentialsException(dbUser.getUsername()+"Invalid Password ");
        }
        return new UsernamePasswordAuthenticationToken(dbUser,password,dbUser.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
