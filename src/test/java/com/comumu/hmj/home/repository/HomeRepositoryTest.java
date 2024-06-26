package com.comumu.hmj.home.repository;

import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.domain.HomeImage;
import com.comumu.hmj.home.domain.HomeType;
import com.comumu.hmj.user.domain.User;
import com.comumu.hmj.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HomeRepositoryTest {

    @Autowired
    private HomeRepository homeRepository;

    @BeforeEach
    public void setUp(){

    }

}
