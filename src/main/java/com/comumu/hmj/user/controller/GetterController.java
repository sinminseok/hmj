package com.comumu.hmj.user.controller;

import com.comumu.hmj.user.dto.LoginDto;
import com.comumu.hmj.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getter")
@RequiredArgsConstructor
public class GetterController {
    private final UserService service;

    @GetMapping("/login")
    public ResponseEntity<String> hello(LoginDto loginDto){
        return ResponseEntity.ok("hello!");
    }


}
