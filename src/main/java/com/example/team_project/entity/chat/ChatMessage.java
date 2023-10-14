package com.example.team_project.entity.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {

    private String roomId;
    private String writer;
    private String message;
}