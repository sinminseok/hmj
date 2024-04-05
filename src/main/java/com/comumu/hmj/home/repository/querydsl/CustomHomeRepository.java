package com.comumu.hmj.home.repository.querydsl;

import com.comumu.hmj.home.domain.Home;

import java.util.List;

public interface CustomHomeRepository {
    //검색 조건에 맞춘 동적 검색
    List<Home> findByFilter();

    //주소를 기반으로 찾기
    List<Home> findByAddress();

    Home test(Integer peopleCount);

}
