package ru.sergei.komarov.med.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
@Data
public class Doctor extends User {

    @ManyToOne
    @JoinColumn(nullable = false)
    private DoctorSpecialization specialization;

    @ManyToOne
    @JoinColumn(nullable = false)
    private DoctorCabinet cabinet;

    @Column(name = "working_now")
    private boolean isWorkingNow;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<PatientTicket> patientTickets;

    @ManyToMany
    @JoinTable(
            name = "doctor_medicalservice",
            joinColumns = {@JoinColumn(name = "doctor_id")},
            inverseJoinColumns = {@JoinColumn(name = "med_service_name")}
    )
    //TODO Fix it
    private List<MedicalService> medicalServices;

}
