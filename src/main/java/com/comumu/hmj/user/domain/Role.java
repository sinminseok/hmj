package com.comumu.hmj.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    PROVDER("GETTER"),
    GETTER("PROVIDER");
    private final String key;

}
