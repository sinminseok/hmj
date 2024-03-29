package com.comumu.hmj.job.controller;

import com.comumu.hmj.account.filter.JwtAuthenticationFilter;
import com.comumu.hmj.home.dto.HomeCreateDto;
import com.comumu.hmj.job.dto.JobCreateDto;
import com.comumu.hmj.job.service.JobService;
import com.comumu.hmj.user.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/job")
public class JobController {

    private final JobService jobService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_PROVIDER')")
    public void createHome(HttpServletRequest request, JobCreateDto jobCreateDto){
        Optional<User> user = jwtAuthenticationFilter.findByAccessToken(request);
        //jobService.save(user.get(), jobCreateDto);
    }
}
