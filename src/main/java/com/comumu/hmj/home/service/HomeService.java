package com.comumu.hmj.home.service;

import com.comumu.hmj.common.service.PostService;
import com.comumu.hmj.home.repository.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService implements PostService {

    private final HomeRepository repository;

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void read() {

    }

    @Override
    public void delete() {

    }
}
