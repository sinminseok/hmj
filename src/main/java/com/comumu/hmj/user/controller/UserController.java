package com.comumu.hmj.user.controller;

import com.comumu.hmj.user.domain.User;
import com.comumu.hmj.user.dto.SignupDto;
import com.comumu.hmj.user.dto.UserDto;
import com.comumu.hmj.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원 가입 api
    @PostMapping("/sign-up")
    public String signUp(@RequestBody SignupDto signupDto) throws Exception {
        log.info("signup method");
        userService.signUp(signupDto);
        return "success";
    }

    @GetMapping("/user")
    public UserDto user() {
        return userService.getCurrentUserInfo();
    }
}
