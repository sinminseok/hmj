package com.comumu.hmj.user.dto;

import com.comumu.hmj.user.domain.Gender;
import com.comumu.hmj.user.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class SignupDto {
    private final String email;

    private final String password;

    private final String nickName;

    private final Integer phoneNumber;

    private final String profileUrl;

    private final Integer age;

    private final Gender gender;

    private final String nationality;

    private final Role role;

}
