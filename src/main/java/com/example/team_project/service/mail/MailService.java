package com.example.team_project.service.mail;

import com.example.team_project.dto.member.Mail;

public interface MailService {

    Mail createMailAndChangePassword(String email);
    void updatePassword(String str, String userEmail);
    String getTempPassword();
    public void mailSend(Mail mail);
    public void updatePassWord(String email, String memberPassword);
}
