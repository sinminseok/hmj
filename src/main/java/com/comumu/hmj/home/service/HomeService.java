package com.comumu.hmj.home.service;

import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.dto.HomeCreateDto;
import com.comumu.hmj.home.repository.HomeRepository;
import com.comumu.hmj.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeRepository homeRepository;

    public void save(User user, HomeCreateDto homeCreateDto) {
        Home home = Home.builder()
                .user(user)
                .bathRoomCount(homeCreateDto.getBathRoomCount())
                .build();
        homeRepository.save(home);
    }

//    public List<HomeDto> findByFilter(){
//
//    }



}
