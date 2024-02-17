package com.comumu.hmj.home.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class BasicInfo {

    private Integer roomCount;

    private Integer bathRoomCount;

    private Integer tenantMaxCount;

    private Integer tenantMinCount;

    private LeaseStatus status;
}
