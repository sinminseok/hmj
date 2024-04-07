package com.comumu.hmj.home.dto;

import com.comumu.hmj.home.domain.Home;
import com.comumu.hmj.home.domain.HomeAddress;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HomeAddressDto {

    private String state;

    private String city;

    private Integer postCode;

    private String detailAddress;

    private String streetName;

    private String streetNumber;

    public HomeAddress toEntity() {
        return HomeAddress.builder()
                .state(state)
                .city(city)
                .postCode(postCode)
                .detailAddress(detailAddress)
                .streetName(streetName)
                .streetNumber(streetNumber)
                .build();
    }

}
