package com.comumu.hmj.job.dto;

import com.comumu.hmj.job.domain.DayAndTime;
import com.comumu.hmj.job.domain.Job;
import com.comumu.hmj.job.domain.JobImage;
import com.comumu.hmj.job.domain.enums.JobType;
import com.comumu.hmj.user.domain.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class JobCreateDto {
    private List<String> imagesUrls;

    private List<DayAndTimeDto> dayAndTimes;

    private String storeName;

    private String position;

    private Integer salary;

    private JobType jobType;

    public Job toEntity(User user){
        Job job = Job.builder()
                .user(user)
                .storeName(storeName)
                .position(position)
                .salary(salary)
                .type(jobType)
                .build();

        job.registerImages(toJobImages(imagesUrls, job));

        job.registerDayAndTimes(toDayAndTimes(dayAndTimes));

        return job;
    }

    private List<DayAndTime> toDayAndTimes(List<DayAndTimeDto> dayAndTimeDtos) {
        List<DayAndTime> dayAndTimes = new ArrayList<>();

        for(DayAndTimeDto dto : dayAndTimeDtos){
            dayAndTimes.add(dto.toEntity());
        }

        return dayAndTimes;
    }

    private List<JobImage> toJobImages(List<String> urls, Job job) {
        List<JobImage> jobImages = new ArrayList<>();

        for(String url : urls) {
            JobImage jobImage = JobImage.builder()
                    .job(job)
                    .imageUrl(url)
                    .build();
            jobImages.add(jobImage);
        }

        return jobImages;
    }
}
