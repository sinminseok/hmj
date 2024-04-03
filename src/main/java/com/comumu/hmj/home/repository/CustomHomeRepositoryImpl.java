package com.comumu.hmj.home.repository;

import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.domain.home.QHome;
import com.comumu.hmj.home.dto.HomeFilterDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomHomeRepositoryImpl implements CustomHomeRepository {

    private final JPAQueryFactory query;
    private final QHome qHome;

    @Override
    public List<Home> findByFilter() {
//        query.selectFrom(qHome)
//                .
        return null;
    }

    @Override
    public List<Home> findByAddress() {
        return null;
    }
}
