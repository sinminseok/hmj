package com.comumu.hmj.job.service;

import com.comumu.hmj.job.domain.Job;
import com.comumu.hmj.job.dto.JobCreateDto;
import com.comumu.hmj.job.repository.JobRepository;
import com.comumu.hmj.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public void save(User user, JobCreateDto jobCreateDto) {
        Job job = Job.builder()
                .user(user)
                .build();

        jobRepository.save(job);
    }
}
