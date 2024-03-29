package com.comumu.hmj.job.domain;

import com.comumu.hmj.post.domain.PostEntity;
import com.comumu.hmj.post.domain.PostFunctionality;
import com.comumu.hmj.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Job extends PostEntity implements PostFunctionality {

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

    private String storeName;

    private JobCategory category;

    private String position;

    private Integer payRate;

    private JobType type;

    @Override
    public void createPost() {

    }

    @Override
    public void readPost() {

    }

    @Override
    public void updatePost() {

    }

    @Override
    public void deletePost() {

    }
}
