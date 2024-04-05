package com.comumu.hmj.job.repository;

import com.comumu.hmj.job.domain.Job;
import com.comumu.hmj.job.repository.querydsl.CustomJobRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long>, CustomJobRepository {
}
