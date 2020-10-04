package ru.sergei.komarov.med.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String phone) {
        super("User phone: " + phone);
    }
}
