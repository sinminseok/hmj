package com.comumu.hmj.user.controller;

import com.comumu.hmj.user.dto.LoginDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    final String LOGIN_REQUEST_DOAMIN = "http://localhost:8080/login";

    @GetMapping(value = "/login--")
    public ModelAndView loginPage() {
        ModelAndView mv = new ModelAndView("/login/loginPage");

        return mv;
    }

    @PostMapping(value = "/login--")
    public String login(LoginDto loginDto, HttpServletResponse response) {
        RestTemplate restTemplate = new RestTemplate();

        // HTTP 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 요청에 포함할 JSON 데이터
        String jsonBody = "{\"email\": \"" + loginDto.getUsername() + "\", \"password\": \"" + loginDto.getPassword() + "\"}";
        System.out.println("Value of Your-Header-Name: " + jsonBody);

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);

        // 요청을 보내고 응답 받기
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(LOGIN_REQUEST_DOAMIN, requestEntity, String.class);

        // 응답 헤더 가져오기
        HttpHeaders gotHeaders = responseEntity.getHeaders();

        // 특정 헤더 값 가져오기
        String token = gotHeaders.getFirst("Authorization");


        Cookie cookie = new Cookie("Authorization", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true); // 서버만 쿠키에 접근
        cookie.setSecure(false);
        response.addCookie(cookie);

        return "redirect:/";
    }
}
