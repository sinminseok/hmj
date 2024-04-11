package com.comumu.hmj.home.repository;

import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.repository.querydsl.CustomHomeRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface HomeRepository extends JpaRepository<Home,Long>, CustomHomeRepository {

//    @Query("SELECT h FROM Home h ORDER BY h.createdAt DESC")
//    List<Home> findAll();

}