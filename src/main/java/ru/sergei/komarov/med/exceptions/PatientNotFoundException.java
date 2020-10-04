package ru.sergei.komarov.med.exceptions;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException() {
    }

    public PatientNotFoundException(int id) {
        this("Patient ID: " + id);
    }

    public PatientNotFoundException(String message) {
        super(message);
    }
}
