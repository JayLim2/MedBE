package ru.sergei.komarov.med.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class BasicNotFoundException extends ResponseStatusException {

    public BasicNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
