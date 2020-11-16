package ru.sergei.komarov.med.exception;

public class SpecializationNotFoundException extends BasicNotFoundException {
    public SpecializationNotFoundException(String message) {
        super("Specialization name: " + message);
    }
}
