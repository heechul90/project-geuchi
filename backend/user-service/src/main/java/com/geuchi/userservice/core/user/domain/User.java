package com.geuchi.userservice.core.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Enumerated(EnumType.STRING)
    private AuthType authType;

    private String refreshToken;

    @Column(nullable = false, columnDefinition = "tinyint default '0'")
    private LocalDateTime lastLoginDate;

    private Integer loginFailCount;

    @Builder(builderMethodName = "createUser")
    public User(String username, String password, String email, RoleType roleType, AuthType authType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleType = roleType;
        this.authType = authType;
    }

    public User update(String email, String password, RoleType roleType) {
        this.email = email;
        this.password = password;
        this.roleType = roleType;
        return this;
    }

    public User updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public User updatePassword(String password) {
        this.password = password;
        return this;
    }
}
