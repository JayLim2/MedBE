package ru.sergei.komarov.med.exception;

public class SpecializationNotFoundException extends RuntimeException {

    public SpecializationNotFoundException() {
    }

    public SpecializationNotFoundException(String message) {
        super("Specialization name: " + message);
    }
}
