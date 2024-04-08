package com.comumu.hmj.home.controller;

import com.comumu.hmj.account.filter.JwtAuthenticationFilter;
import com.comumu.hmj.home.dto.CityDto;
import com.comumu.hmj.home.dto.HomeCreateDto;
import com.comumu.hmj.home.dto.SimpleHomeDto;
import com.comumu.hmj.home.service.HomeService;
import com.comumu.hmj.user.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/home")
public class HomeController {

    private final HomeService homeService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_PROVIDER')")
    public void saveHome(HttpServletRequest request, @RequestBody HomeCreateDto homeCreateDto) {
        Optional<User> user = jwtAuthenticationFilter.findByAccessToken(request);
        homeService.save(user.get(), homeCreateDto);
    }

    @GetMapping("/read/all/city")
    //@PreAuthorize("hasAnyRole('ROLE_PROVIDER','ROLE_GETTER")
    public List<SimpleHomeDto> findHomeByCity(HttpServletRequest request, @RequestBody CityDto cityDto) {
        return homeService.findByCity(cityDto);
    }
//
    //GET /home/all?pageNo=0&pageSize=10
    @GetMapping("/read/all")
    public List<SimpleHomeDto> findAllByPage(HttpServletRequest request, @RequestParam(defaultValue = "0") int pageNumber,
                                             @RequestParam(defaultValue = "10") int pageSize){
        return homeService.findAllByPage(pageNumber, pageSize);
    }
}
