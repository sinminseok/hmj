package com.comumu.hmj.home.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class Price {

    private Integer bill;
    private Integer bond;
    private Integer rentFeePerWeek;
}
