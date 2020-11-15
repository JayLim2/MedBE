package ru.sergei.komarov.med.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "specializations")
@Data
public class DoctorSpecialization {

    @Id
    @JsonValue
    private String name;

    @OneToMany(mappedBy = "specialization")
    @JsonBackReference
    private List<Doctor> doctors;

}
