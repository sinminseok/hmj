package com.comumu.hmj.job.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class JobCreateDto {
    private List<String> imagesUrls;

    private String storeName;

    private String position;

    private Integer salary;
}
