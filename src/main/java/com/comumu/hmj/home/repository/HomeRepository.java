package com.comumu.hmj.home.repository;

import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.repository.querydsl.CustomHomeRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home,Long>, CustomHomeRepository {

}