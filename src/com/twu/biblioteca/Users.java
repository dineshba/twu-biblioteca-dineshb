package com.twu.biblioteca;

public class Users {
    private final String role;
    private final String number;
    private final String password;
    private final String name;
    private final String email;
    private final String phoneNumber;

    public Users(String number, String password, String role, String name, String email, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.number = number;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public boolean authenticate(String requestedNumber, String requestedPassword, String requestedRole) {
        return requestedNumber.equals(number) && requestedPassword.equals(password) && requestedRole.equals(role);
    }

    public boolean isAdmin() {
        return role.equals("Admin");
    }

    public boolean isEmpty() {
        return role.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %-15s", number, name, email, phoneNumber);
    }

    public boolean hasName(Users that) {
        return number.equals(that.number);
    }
}
