package ru.sergei.komarov.med.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "med_services")
@Data
public class MedicalService {

    @Id
    private String name;

    @Column(nullable = false)
    private String description;

    private String recommendations;

    @Column(name = "available", nullable = false)
    private boolean isAvailable;

    @OneToMany(mappedBy = "medicalService")
    private List<PatientTicket> patientTickets;

    @ManyToMany
    @JoinTable(
            name = "doctor_medicalservice",
            joinColumns = {@JoinColumn(name = "med_service_name")},
            inverseJoinColumns = {@JoinColumn(name = "doctor_id")}
    )
    private List<Doctor> doctors;

}
