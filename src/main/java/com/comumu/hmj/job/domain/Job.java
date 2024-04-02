package com.comumu.hmj.job.domain;

import com.comumu.hmj.post.domain.PostEntity;
import com.comumu.hmj.post.domain.PostFunctionality;
import com.comumu.hmj.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Job extends PostEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "job", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<JobImage> images;

    //날짜별 근무 시간 ex) 일요일 1시 부터 10시
    @JsonIgnore
    @OneToMany(mappedBy = "job", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<DayAndTime> dayAndTime;

    //가게이름
    private String storeName;

    @Enumerated(EnumType.STRING)
    private JobCategory category;

    //구인 포지션
    private String position;

    //시급
    private Integer salary;

    //일 타입
    private JobType type;

}
