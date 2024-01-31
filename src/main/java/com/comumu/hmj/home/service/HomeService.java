package com.comumu.hmj.home.service;

import com.comumu.hmj.home.repository.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeRepository repository;

}
