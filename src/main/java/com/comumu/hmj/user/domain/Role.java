package com.comumu.hmj.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    PROVIDER("ROLE_PROVIDER"),
    GETTER("ROLE_GETTER"),
    ADMIN("ROLE_ADMIN");

    private final String key;

}
