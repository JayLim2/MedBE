package ru.sergei.komarov.med.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Doctor> doctors;

}
