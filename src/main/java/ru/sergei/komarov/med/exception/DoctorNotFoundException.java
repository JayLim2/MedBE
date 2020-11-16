package ru.sergei.komarov.med.exception;

public class DoctorNotFoundException extends BasicNotFoundException {

    public DoctorNotFoundException(int id) {
        this("Doctor ID: " + id);
    }

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
