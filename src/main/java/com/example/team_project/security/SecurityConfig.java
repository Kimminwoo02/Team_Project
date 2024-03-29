package com.example.team_project.security;

import com.example.team_project.entity.AuditingFields;
import com.example.team_project.entity.member.Member;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig implements AuditorAware<Long>{
    private final UserDetailsService userDetailsService;

    private final CustomAuthSuccessHandler authenticationSuccessHandler;



    // @createdBy 처리
    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null||!authentication.isAuthenticated()) return null;
        return Optional.ofNullable(((CustomUserDetails) authentication.getPrincipal()).getMember().getMemberId());
    }

    private static final int ONE_MONTH = 2678400;

    @Bean
    public BCryptPasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider(){
        return new CustomAuthenticationProvider(userDetailsService,encode());
    }
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
                .requestMatchers(new AntPathRequestMatcher("/images/**"))
                .requestMatchers(new AntPathRequestMatcher("/error"))
                .requestMatchers(new AntPathRequestMatcher("/matchingMember"))
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());

    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspect) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable
                )

                .authorizeHttpRequests(auth->auth
                        .requestMatchers(new MvcRequestMatcher(introspect,"/home")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/swagger-ui.html")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/login")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/id")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/pw")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/findemail")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/findpw")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/signup")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/boardMain")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/welcome")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/detail")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/chat")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/write")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/mypageEdit")).permitAll()
                        .requestMatchers(new MvcRequestMatcher(introspect,"/emailCheck")).permitAll()


                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .successHandler(authenticationSuccessHandler)
                        .usernameParameter("email")

                )

                .logout((logout)->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/home")
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                )



                .build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
