package com.comumu.hmj.user.service;

import com.comumu.hmj.account.user.CustomUser;
import com.comumu.hmj.user.domain.User;
import com.comumu.hmj.user.dto.SignupDto;
import com.comumu.hmj.user.dto.UserDto;
import com.comumu.hmj.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String ALREADY_EXIST_EMAIL_ERROR = "이미 존재하는 이메일 입니다.";
    private static final String ALREADY_EXIST_NICKNAME_ERROR = "이미 존재하는 닉네임 입니다.";

    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            // 인증된 사용자의 정보에서 ID 가져오기
            CustomUser userDetails = (CustomUser) authentication.getPrincipal();
            log.info(String.valueOf(userDetails.getId()));
            return userDetails.getId();
        }
        return null; // 인증되지 않은 경우 또는 사용자 정보가 없는 경우
    }

    public UserDto getCurrentUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            // 인증된 사용자의 정보에서 ID 가져오기
            CustomUser userDetails = (CustomUser) authentication.getPrincipal();
            return UserDto.builder().id(userDetails.getId()).email(userDetails.getUsername()).build();
        }
        return null; // 인증되지 않은 경우 또는 사용자 정보가 없는 경우
    }

    public void signUp(SignupDto signupDto) throws Exception {
        log.info("signup method2");
        if(userRepository.findByEmail(signupDto.getEmail()).isPresent()){
            throw new Exception(ALREADY_EXIST_EMAIL_ERROR);
        }

        if(userRepository.findByNickName(signupDto.getNickname()).isPresent()){
            throw new Exception(ALREADY_EXIST_NICKNAME_ERROR);
        }

        User user = User.builder()
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .nickName(signupDto.getNickname())
                .nationality(signupDto.getNationality())
                .phoneNumber(signupDto.getPhoneNumber())
                .role(signupDto.getRole())
                .build();

        user.passwordEncode(passwordEncoder);
        userRepository.save(user);
    }

}
