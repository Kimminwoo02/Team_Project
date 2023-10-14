package com.example.team_project.entity.chat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class ChatRoom {

    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatRoom createChatRoom (String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}