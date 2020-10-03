package ru.sergei.komarov.med.models;

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

    @ManyToOne
    @JoinColumn(name = "phone", nullable = false)
    private User user;

}
