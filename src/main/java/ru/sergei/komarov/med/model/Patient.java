package ru.sergei.komarov.med.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
public class Patient extends User {

    @Column(name = "address", nullable = false)
    private String registrationAddress;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(name = "insurance_policy", nullable = false)
    private String insurancePolicyNumber;

}
