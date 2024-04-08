package com.comumu.hmj.home.dto;

import com.comumu.hmj.home.domain.HomeType;
import lombok.Builder;

@Builder
public class SimpleHomeDto {
    private String address;
    private String imageUrl;
    private Integer bond;
    private Integer bill;
    private HomeType homeType;
}
