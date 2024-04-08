package com.comumu.hmj.home.service;

import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.dto.CityDto;
import com.comumu.hmj.home.dto.HomeCreateDto;
import com.comumu.hmj.home.dto.HomeDto;
import com.comumu.hmj.home.dto.SimpleHomeDto;
import com.comumu.hmj.home.repository.HomeRepository;
import com.comumu.hmj.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeRepository homeRepository;

    public void save(User user, HomeCreateDto homeCreateDto) {
        // 코드 구현
        Home home = homeCreateDto.toEntity(user);

        homeRepository.save(home);
    }

    public List<SimpleHomeDto> findByCity(CityDto cityDto) {
        List<Home> byCity = homeRepository.findByCity(cityDto.getCityName());
        return toSimpleDtos(byCity);
    }

    public HomeDto findById(Long id){
        Optional<Home> home = homeRepository.findById(id);
        return home.get().toDto();
    }

    public List<SimpleHomeDto> findAllByPage(int pageNumber, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);

        List<Home> all = homeRepository.findAll(pageable).getContent();

        return toSimpleDtos(all);
    }

    private List<SimpleHomeDto> toSimpleDtos(List<Home> homes) {
        return homes.stream()
                .map(Home::toSimpleDto)
                .collect(Collectors.toList());
    }
}
