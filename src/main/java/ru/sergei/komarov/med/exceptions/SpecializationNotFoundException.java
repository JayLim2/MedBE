package ru.sergei.komarov.med.exceptions;

public class SpecializationNotFoundException extends RuntimeException {

    public SpecializationNotFoundException() {
    }

    public SpecializationNotFoundException(String message) {
        super("Specialization name: " + message);
    }
}
