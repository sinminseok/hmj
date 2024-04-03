package com.comumu.hmj.home.repository;

import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.dto.HomeFilterDto;

import java.util.List;

public interface CustomHomeRepository {
    //검색 조건에 맞춘 동적 검색
    List<Home> findByFilter();

    //주소를 기반으로 찾기
    List<Home> findByAddress();

}
