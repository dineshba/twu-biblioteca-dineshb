package com.twu.biblioteca;

public class Users {
    private final String role;
    private final String name;
    private final String password;

    public Users(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public boolean authenticate(String requestedName, String requestedPassword, String requestedRole) {
        return requestedName.equals(name) && requestedPassword.equals(password) && requestedRole.equals(role);
    }

    public boolean isAdmin() {
        return role.equals("Admin");
    }

    public boolean isEmpty() {
        return role.isEmpty();
    }
}
