package com.comumu.hmj.home.repository.querydsl;

import com.comumu.hmj.config.TestConfig;
import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.repository.HomeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest // JPA 컴포넌트들만을 위한 테스트 애노테이션이다. (JPA에 필요한 설정들에 대해서만 Bean을 등록한다.)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 테스트용 DB 설정 애노테이션
@Import(TestConfig.class)
class CustomHomeRepositoryImplTest {

    @Autowired
    private HomeRepository homeRepository;

    @Test
    void test() {
        Home home = Home.builder()
                .peopleCount(5)
                .build();

        homeRepository.save(home);

        Home test = homeRepository.test(5);

        Assertions.assertThat(test.getPeopleCount()).isEqualTo(5);
    }

}
