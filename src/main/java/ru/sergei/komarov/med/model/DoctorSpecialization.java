package ru.sergei.komarov.med.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonValue;
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
    @JsonBackReference
    private List<Doctor> doctors;

}
