package com.comumu.hmj.user.controller;

import com.comumu.hmj.user.dto.SignupDto;
import com.comumu.hmj.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/user")
public class UserController {
    private final UserService userService;

    // 회원 가입 api
    @PostMapping("/sign-up")
    public String signUp(@RequestBody SignupDto signupDto) throws Exception {
        userService.signUp(signupDto);
        return "success";
    }

}
