package com.geuchi.userservice.core.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthType {
    SELF, GOOGLE, KAKAO, NAVER
}
