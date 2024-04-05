package com.comumu.hmj.home.controller;

import com.comumu.hmj.account.filter.JwtAuthenticationFilter;
import com.comumu.hmj.home.dto.HomeCreateDto;
import com.comumu.hmj.home.service.HomeService;
import com.comumu.hmj.user.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/home")
public class HomeController {

    private final HomeService homeService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_PROVIDER')")
    public void createHome(HttpServletRequest request,@RequestBody HomeCreateDto homeCreateDto) {
        Optional<User> user = jwtAuthenticationFilter.findByAccessToken(request);
        homeService.save(user.get(), homeCreateDto);
    }

    /**
     * 추후 위치정보(좌표)기반으로 조회하는 기능 추가
     */
//    @GetMapping("")
//    @PreAuthorize("hasAnyRole('ROLE_GETTER','ROLE_PROVIDER')")
//    public ResponseEntity<List<HomeDto>> readAll(){
//
//    }

}
