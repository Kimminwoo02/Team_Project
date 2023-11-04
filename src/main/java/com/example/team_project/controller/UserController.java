package com.example.team_project.controller;

import com.example.team_project.dto.auth.SignupDto;
import com.example.team_project.dto.member.Mail;
import com.example.team_project.dto.member.MemberSearchCond;
import com.example.team_project.dto.member.MemberUpdateDto;
import com.example.team_project.entity.member.Member;
import com.example.team_project.service.mail.MailService;
import com.example.team_project.dto.member.MemberInfoDTO;
import com.example.team_project.security.CustomUserDetails;
import com.example.team_project.service.member.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Member", description = "Member 객체 및 아이디, 비밀번호에 관한 API입니다.")
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
    @Operation(summary = "find password", description = "비밀번호 찾기 페이지를 반환한다.")
    public String findPw(){
        return "main/findmenu/findpw";
    }
    @GetMapping("/findemail")
    @Operation(summary = "find email", description = "아이디 찾기 페이지를 반환한다.")
    public String findEmail(){
        return "main/findmenu/findemailid";
    }

    // REST 방식에서 값을 읽어내는 동작은 GET이다. ★ 매핑 주소 find_id 아닌 find/id으로 주는 것 주의!
    @Transactional
    @PostMapping("/findemail")
    @Operation(summary = "find email", description = "이름과 휴대폰 번호를 이용하여 DB에 저장된 회원 아이디값을 찾아온다.")
    public String findId(String name, String phone , RedirectAttributes rttr) {
        MemberSearchCond memberSearchCond = new MemberSearchCond(name,phone);
        Member user = memberService.getMemberId(memberSearchCond);
        log.info(name + " +++++++" + phone + "cccccccc"  );
        if(user.getEmail() == null) {
            rttr.addAttribute("data", "");
        }else {
            rttr.addAttribute("data", user);
        }
        return "redirect:/id";
    }
    @GetMapping("/id")
    public String foundid(@ModelAttribute("data") MemberSearchCond memberSearchCond, Model model){
        Member member = memberService.getMemberId(memberSearchCond);
        model.addAttribute("email", member.getEmail());
        return "main/findmenu/findIdView";
    }


    @Transactional
    @PostMapping("/findpw" )
    public String sendEmail(MemberSearchCond memberSearchCond , RedirectAttributes rttr){
        Mail dto = mailService.createMailAndChangePassword(memberSearchCond.getEmail());
        rttr.addFlashAttribute("data", memberSearchCond);
        mailService.mailSend(dto);

        return "redirect:/pw";
    }
    @GetMapping("/pw")
    public String foundpw(@ModelAttribute("data") MemberSearchCond memberSearchCond, Model model){
        model.addAttribute("email", memberSearchCond.getEmail());
        return "main/findmenu/findPwView";
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
        memberService.join(signupDto);

        return "redirect:/welcome";

    }

    @PostMapping( "/emailCheck")
    @ResponseBody
    public Long idCheck(String email) {

        return memberService.emailCheck(email);

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

}
