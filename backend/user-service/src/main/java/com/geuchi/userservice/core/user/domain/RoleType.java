package com.geuchi.userservice.core.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum RoleType {

    ANONYMOUS("ROLE_ANONYMOUS", "손님"),
    USER("ROLE_USER", "일반 사용자"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;

    /**
     * 권한 id로 상수 검색
     */
    public static RoleType findByKey(String key) {
        return Arrays.stream(RoleType.values()).filter(role -> role.getKey().equals(key)).findAny().orElse(null);
    }
}
