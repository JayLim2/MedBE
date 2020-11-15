package ru.sergei.komarov.med.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_id_seq")
    @SequenceGenerator(name = "patient_id_seq")
    private int id;

    @Column(name = "address", nullable = false)
    private String registrationAddress;

    @Column(nullable = false)
    private LocalDate birthday;

    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column(name = "insurance_policy", nullable = false)
    private String insurancePolicyNumber;

}
