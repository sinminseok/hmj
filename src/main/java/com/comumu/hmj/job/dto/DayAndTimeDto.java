package com.comumu.hmj.job.dto;

import com.comumu.hmj.job.domain.DayAndTime;
import com.comumu.hmj.job.domain.enums.Day;

import java.time.LocalTime;

public class DayAndTimeDto {
    private Day day;

    private LocalTime startTime;

    private LocalTime endTime;

    public DayAndTime toEntity(){
        return DayAndTime.builder()
                .day(day)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
