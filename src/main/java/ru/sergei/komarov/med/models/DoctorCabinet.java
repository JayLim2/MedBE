package ru.sergei.komarov.med.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cabinets")
@Data
public class DoctorCabinet {

    @Id
    private String name;

    private String specialization;

    @Column(name = "max_count", nullable = false)
    private int recommendedDoctorsCount;

    @OneToMany(mappedBy = "cabinet")
    private List<Doctor> doctors;

}
