package ru.sergei.komarov.med.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_id_seq")
    @SequenceGenerator(name = "doctor_id_seq")
    private int id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private DoctorSpecialization specialization;

    @ManyToOne
    @JoinColumn(nullable = false)
    private DoctorCabinet cabinet;

    @Column(name = "working_now")
    private boolean isWorkingNow;

    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    @OneToMany(mappedBy = "doctor")
    private List<PatientTicket> patientTickets;

    @ManyToMany
    @JoinTable(
            name = "doctor_medicalservice",
            joinColumns = {@JoinColumn(name = "doctor_id")},
            inverseJoinColumns = {@JoinColumn(name = "med_service_name")}
    )
    private List<MedicalService> medicalServices;

}
