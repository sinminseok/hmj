package com.comumu.hmj.home.repository;

import com.comumu.hmj.home.domain.home.Home;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface HomeRepository extends JpaRepository<Home,Long> {

}