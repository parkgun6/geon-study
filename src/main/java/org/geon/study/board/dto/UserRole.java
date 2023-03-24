package org.geon.study.board.dto;

import java.util.Arrays;

public enum UserRole {

    GUEST("1"),
    USER("2"),
    MANAGER("3"),
    ADMIN("4");

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

    public String getRole() {
        return role;
    }

    public static String parseValue(String role) throws IllegalArgumentException {
        try {
            UserRole exampleEnum = UserRole.valueOf(role);
            return exampleEnum.getRole();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Role: " + role, e);
        }
    }

    public boolean hashUserRole(String value) {
        return role.equals(value);
    }
}
