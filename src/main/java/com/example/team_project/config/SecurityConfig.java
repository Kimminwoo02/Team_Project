package com.example.team_project.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                .requestMatchers(new AntPathRequestMatcher("/favicon.ico"))
                .requestMatchers(new AntPathRequestMatcher("/css/**"))
                .requestMatchers(new AntPathRequestMatcher("/js/**"))
                .requestMatchers(new AntPathRequestMatcher("/fonts/**"))
                .requestMatchers(new AntPathRequestMatcher("/fragment/**"))
                .requestMatchers(new AntPathRequestMatcher("/config/**"))
                .requestMatchers(new AntPathRequestMatcher("/content/**"))
                .requestMatchers(new AntPathRequestMatcher("/images/**"));
    }



    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspect) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(auth->auth
                        .requestMatchers(new MvcRequestMatcher(introspect,"/home")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/loginPage")).permitAll()
                        .anyRequest().authenticated())

                .formLogin(login -> login
                        .loginPage("/loginPage")
                        .defaultSuccessUrl("/home")
                        .loginProcessingUrl("/home")
                        .usernameParameter("id")
                        .passwordParameter("password")

                )

                .build();

    }
}
