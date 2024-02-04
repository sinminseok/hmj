package com.comumu.hmj.user.controller;

import com.comumu.hmj.user.dto.UserSignUpDto;
import com.comumu.hmj.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
@RequiredArgsConstructor
public class ProviderController {
    private final UserService service;

//    @GetMapping("/save")
//    public ResponseEntity<String> save(UserSignUpDto userSignUpDto){
//
//    }
}
