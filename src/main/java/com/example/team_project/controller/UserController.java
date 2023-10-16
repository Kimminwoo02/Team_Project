package com.example.team_project.controller;

import com.example.team_project.dto.Board.BoardUpdate;
import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.dto.member.Mail;
import com.example.team_project.dto.member.MemberSearchCond;
import com.example.team_project.dto.member.MemberUpdateDto;
import com.example.team_project.entity.Member;
import com.example.team_project.service.mail.MailService;
import com.example.team_project.dto.member.MemberInfoDTO;
import com.example.team_project.entity.Member;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final MemberService memberService;
    private final MailService mailService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        String uri = request.getHeader("Referer");
        if (uri != null && !uri.contains("/login")) {
            request.getSession().setAttribute("prevPage", uri);
        }
        return "main/loginPage";
    }

    @GetMapping("/findpw")
    public String findPw(){
        return "main/findpw";
    }
    @GetMapping("/findemail")
    public String findEmail(){
        return "main/findemailid";
    }

    // REST 방식에서 값을 읽어내는 동작은 GET이다. ★ 매핑 주소 find_id 아닌 find/id으로 주는 것 주의!
    @ResponseBody
    @PostMapping("/findemail")
    public ResponseEntity<String> findId(MemberSearchCond memberSearchCond) {
        Member user = memberService.getMemberId(memberSearchCond);
        if(user.getEmail() == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("아이디를 찾지 못했습니다.");
        }
        return ResponseEntity.ok(user.getEmail());
    }
    @Transactional
    @PostMapping("/findpw")
    public String sendEmail(MemberSearchCond memberSearchCond){
        Mail dto = mailService.createMailAndChangePassword(memberSearchCond.getEmail());
        mailService.mailSend(dto);

        return "redirect:/home";
    }



    @GetMapping("/signup")
    public String signup(){
        return "main/signup";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:/home";
    }

    @PostMapping("/signup")
    public String signup1(@ModelAttribute SignupDto signupDto) {
        log.info(String.valueOf(signupDto.getAddr() + "#####" + signupDto.getDetailAddr()));
        memberService.join(signupDto);

        return "redirect:/welcome";

    }

    @GetMapping("/mypage")
    public String mypage1(){
        return "main/mypage";
    }

    @GetMapping("/mypageEdit")
    public String mypageUpdate(Model model, @AuthenticationPrincipal CustomUserDetails principal){
        MemberInfoDTO member = memberService.getLoginUserById(principal.getMemberId());
        model.addAttribute("member", member);
        return "main/mypage";
    }

    @PutMapping("/mypageEdit")
    public String mypageUpdate(@ModelAttribute MemberUpdateDto memberUpdateDto, @AuthenticationPrincipal CustomUserDetails principal) {
        memberService.update(memberUpdateDto,principal.getMemberId());
        
        //세션 재등록
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(memberUpdateDto.getEmail(), memberUpdateDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/home";
    }

    @GetMapping("/mySchedule")
    public String mypage2(){
        return "main/mySchedule";
    }


}
