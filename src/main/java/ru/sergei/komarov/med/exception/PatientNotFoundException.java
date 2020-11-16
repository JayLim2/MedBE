package ru.sergei.komarov.med.exception;

public class PatientNotFoundException extends BasicNotFoundException {
    public PatientNotFoundException(int id) {
        this("Patient ID: " + id);
    }

    public PatientNotFoundException(String message) {
        super(message);
    }
}
