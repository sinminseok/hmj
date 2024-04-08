package com.comumu.hmj.home.repository.querydsl;

import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.domain.QHome;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomHomeRepositoryImpl implements CustomHomeRepository {

    private final JPAQueryFactory query;
    private final QHome qHome = QHome.home;

    @Override
    public List<Home> findByFilter() {
        return null;
    }

    @Override
    public List<Home> findByAddress() {
        return null;
    }

    @Override
    public List<Home> findByCity(String cityName) {
        return query.selectFrom(qHome)
                .where(qHome.homeAddress.city.like("%" + cityName +"%"))
                .fetch();
    }

    @Override
    public Home test(Integer peopleCount) {
        Home first = query.selectFrom(qHome)
                .where(qHome.peopleCount.eq(peopleCount))
                .orderBy(qHome.peopleCount.desc())
                .stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("에러 발생"));
        return first;
    }
}
