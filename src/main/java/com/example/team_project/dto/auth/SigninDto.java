package com.example.team_project.dto.auth;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SigninDto {
    @NotNull
    private String email;

    @NotNull
    private String password;
}
