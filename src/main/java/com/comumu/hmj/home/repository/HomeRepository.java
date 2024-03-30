package com.comumu.hmj.home.repository;

import com.comumu.hmj.home.domain.home.Home;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

public interface HomeRepository extends JpaRepository<Home,Long> {

//    @Query("SELECT h FROM Home h ORDER BY h.createdAt DESC")
//    List<Home> findAll();

}