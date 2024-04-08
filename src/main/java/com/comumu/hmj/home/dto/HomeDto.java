package com.comumu.hmj.home.dto;

import com.comumu.hmj.home.domain.HomeType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class HomeDto {

    private Long id;

    private HomeAddressDto address;

    private List<String> images;

    private Integer bathRoomCount;

    private Integer peopleCount;

    private Integer bond;

    private HomeType homeType;

    private String shortIntroduce;

    private String introduce;

    private Integer bill;

    private Integer viewCount;

}
