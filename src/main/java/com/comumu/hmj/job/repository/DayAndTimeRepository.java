package com.comumu.hmj.job.repository;

import com.comumu.hmj.job.domain.DayAndTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayAndTimeRepository extends JpaRepository<DayAndTime, Long> {
}
