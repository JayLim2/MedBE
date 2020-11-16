package ru.sergei.komarov.med.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    PATIENT, DOCTOR, ADMIN;

    @Override
    public String getAuthority() {
        return toString();
    }
}
