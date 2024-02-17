package com.comumu.hmj.common.dao;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class Address {

    private String zipCode;
    private String unit;
    private String street;
    private String city;
}
