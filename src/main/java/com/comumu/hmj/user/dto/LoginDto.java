package com.comumu.hmj.user.dto;

import lombok.Getter;

@Getter
public class LoginDto {
    private final String id;
    private final String password;

    public LoginDto(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
