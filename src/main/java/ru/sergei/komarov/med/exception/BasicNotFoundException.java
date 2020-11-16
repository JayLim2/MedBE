package ru.sergei.komarov.med.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BasicNotFoundException extends ResponseStatusException {

    public BasicNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }

    public BasicNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
