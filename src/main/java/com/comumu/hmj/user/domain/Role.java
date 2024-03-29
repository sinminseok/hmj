package com.comumu.hmj.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    PROVIDER("ROLE_PROVIDER"),
    GETTER("ROLE_GETTER");

    private final String key;

}
