package com.comumu.hmj.user.service;

import com.comumu.hmj.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderService {
    private final UserRepository repository;

    public void create(){

    }
}
