package com.example.team_project.service.mail;

import com.example.team_project.dto.member.Mail;
import com.example.team_project.entity.Member;
import com.example.team_project.repository.MemberRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailServiceImpl implements MailService{
    private final MemberRepository memberRepository;
    private final MailSender mailSender;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Mail createMailAndChangePassword(String email) {
        String str = getTempPassword();
        Mail dto = new Mail();
        dto.setAddress(email);
        dto.setTitle("Actimate 임시비밀번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요. Actimate 임시비밀번호 안내 관련 이메일 입니다." + " 회원님의 임시 비밀번호는 " + str + " 입니다." + "로그인 후에 비밀번호를 변경을 해주세요");
        updatePassword(str,email);
        return dto;
    }

    @Override
    public void updatePassword(String str, String userEmail) {
        Member member = memberRepository.findByEmail(userEmail);
        member.setPassword(passwordEncoder.encode(str));
        System.out.println(" 잘 됏겠지?");

    }

    @Override
    public String getTempPassword() {
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }

    @Override
    public void mailSend(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getAddress());
        message.setSubject(mail.getTitle());
        message.setText(mail.getMessage());
        message.setFrom("made_power@naver.com");
        message.setReplyTo("made_power@naver.com");
        System.out.println("message"+message);
        mailSender.send(message);
    }

    @Override
    public void updatePassWord(String email, String memberPassword) {
        Member member = memberRepository.findByEmail(email);
        member.setPassword(memberPassword);
    }
}
