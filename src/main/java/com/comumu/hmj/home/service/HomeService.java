package com.comumu.hmj.home.service;

import com.comumu.hmj.common.service.PostService;
import com.comumu.hmj.home.domain.home.Home;
import com.comumu.hmj.home.dto.HomeCreateDto;
import com.comumu.hmj.home.dto.HomeDto;
import com.comumu.hmj.home.repository.HomeRepository;
import com.comumu.hmj.user.domain.User;
import com.comumu.hmj.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeRepository homeRepository;
    private final UserRepository userRepository;

    public void save(User user, HomeCreateDto homeCreateDto) {
        Home home = Home.builder()
                .user(user)
                .bathRoomCount(homeCreateDto.getBathRoomCount())
                .address(homeCreateDto.getAddress())
                .build();
        homeRepository.save(home);
    }

    // 위치를 기반으로 조회하게끔 변경
//    public List<HomeDto> findAll() {
//        List<Home> all = homeRepository.findAll();
//    }


}
