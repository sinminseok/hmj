package com.comumu.hmj.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class LoginDto {
    private final String username;
    private final String password;

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
