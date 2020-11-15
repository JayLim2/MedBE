package ru.sergei.komarov.med.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String phone) {
        super("User phone: " + phone);
    }
}
