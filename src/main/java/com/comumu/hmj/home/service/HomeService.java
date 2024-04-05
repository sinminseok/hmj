package com.comumu.hmj.home.service;

import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.domain.HomeAddress;
import com.comumu.hmj.home.domain.HomeImage;
import com.comumu.hmj.home.dto.HomeCreateDto;
import com.comumu.hmj.home.repository.HomeRepository;
import com.comumu.hmj.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeRepository homeRepository;

    public void save(User user, HomeCreateDto homeCreateDto) {
        // 코드 구현
        Home home = homeCreateDto.toEntity(user);

        homeRepository.save(home);
    }





}
