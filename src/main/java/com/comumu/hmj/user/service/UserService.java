package com.comumu.hmj.user.service;

import com.comumu.hmj.user.domain.Role;
import com.comumu.hmj.user.domain.User;
import com.comumu.hmj.user.dto.LoginDto;
import com.comumu.hmj.user.dto.SignupDto;
import com.comumu.hmj.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignupDto signupDto) throws Exception {
        if(userRepository.findByEmail(signupDto.getEmail()).isPresent()){
            throw new Exception("이미 존재하는 이메일 입니다.");
        }

        if(userRepository.findByNickName(signupDto.getNickName()).isPresent()){
            throw new Exception("이미 존재하는 이메일 입니다.");
        }

        User user = User.builder()
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .nickName(signupDto.getNickName())
                .nationality(signupDto.getNationality())
                .phoneNumber(signupDto.getPhoneNumber())
                .role(signupDto.getRole())
                .build();

        user.passwordEncode(passwordEncoder);
        userRepository.save(user);
    }

    public void login(LoginDto loginDto) {

    }


}
