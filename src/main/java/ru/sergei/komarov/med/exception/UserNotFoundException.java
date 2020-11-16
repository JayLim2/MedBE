package ru.sergei.komarov.med.exception;

public class UserNotFoundException extends BasicNotFoundException {

    public UserNotFoundException(String phone) {
        super("User phone: " + phone);
    }
}
