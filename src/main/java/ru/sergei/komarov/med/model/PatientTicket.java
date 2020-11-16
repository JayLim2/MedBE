package ru.sergei.komarov.med.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "medical_service", nullable = false)
    @JsonBackReference("PatientTicket-MedicalService")
    private MedicalService medicalService;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "patient_id", nullable = false)
    //@JsonManagedReference("PatientTicket-Patient")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonBackReference("PatientTicket-Doctor")
    private Doctor doctor;

    private String prescriptions;

}
