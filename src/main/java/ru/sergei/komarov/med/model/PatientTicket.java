package ru.sergei.komarov.med.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient_tickets")
@Data
public class PatientTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_ticket_id_seq")
    @SequenceGenerator(name = "patient_ticket_id_seq")
    private int id;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "medical_service", nullable = false)
    private MedicalService medicalService;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    private String prescriptions;

}
