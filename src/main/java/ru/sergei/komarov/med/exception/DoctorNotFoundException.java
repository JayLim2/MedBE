package ru.sergei.komarov.med.exception;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException() {
    }

    public DoctorNotFoundException(int id) {
        this("Doctor ID: " + id);
    }

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
