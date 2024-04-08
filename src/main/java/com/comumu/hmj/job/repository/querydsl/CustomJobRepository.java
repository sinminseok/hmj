package com.comumu.hmj.job.repository.querydsl;

import com.comumu.hmj.job.domain.Job;

import java.util.List;

public interface CustomJobRepository {
    List<Job> findByFilter();
}
