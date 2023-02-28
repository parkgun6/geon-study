package org.geon.study.board.model;

import lombok.Getter;

import java.util.Arrays;

public enum UserRole {

    GUEST("1"),
    USER("2"),
    MANAGER("3"),
    ADMIN("4");

    @Getter
    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public static UserRole findByUserRole(String role) {
        return Arrays.stream(UserRole.values())
                .filter(input -> input.hashUserRole(role))
                .findAny()
                .orElse(GUEST);
    }

    public boolean hashUserRole(String value) {
        return role.equals(value);
    }
}
