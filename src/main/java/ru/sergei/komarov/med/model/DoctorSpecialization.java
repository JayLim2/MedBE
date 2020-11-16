package ru.sergei.komarov.med.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specializations")
@Data
public class DoctorSpecialization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specialization_id_seq")
    @SequenceGenerator(name = "specialization_id_seq")
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "specialization")
    @JsonManagedReference("Doctor-DoctorSpecialization")
    private List<Doctor> doctors;

}
