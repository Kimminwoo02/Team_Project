package com.example.team_project.controller.chat;

import com.example.team_project.entity.chat.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequiredArgsConstructor
public class StompChatClient {
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping(value = "/chat/enter")
    public void enter(ChatMessage chatMessage) {
        System.out.println("연결성공");
        chatMessage.setMessage(chatMessage.getWriter() + "님이 채팅방에 참여하셨습니다.");
        messagingTemplate.convertAndSend("/sub/chat/room/" + chatMessage.getRoomId(), chatMessage);
    }

    @MessageMapping(value = "/chat/message")
    public void message(ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/sub/chat/room/"+chatMessage.getRoomId(),chatMessage);
    }
}