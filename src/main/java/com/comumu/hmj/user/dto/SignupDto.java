package com.comumu.hmj.user.dto;

import com.comumu.hmj.user.domain.Gender;
import com.comumu.hmj.user.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {

    private String email;

    private String password;

    private String nickname;

    private  Integer phoneNumber;

    private  String profileUrl;

    private  Integer age;

    private  Gender gender;

    private  String nationality;

    private  Role role;

}
