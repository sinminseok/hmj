package com.comumu.hmj.job.domain;

import com.comumu.hmj.job.domain.enums.Day;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

// ex) 일요일 1시 ~10시
@Entity
@Getter
@NoArgsConstructor
public class DayAndTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "day_and_time_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    @Enumerated(EnumType.STRING)
    private Day day;

    private LocalTime startTime;

    private LocalTime endTime;

    public void update(DayAndTime newEntity){

    }
}
