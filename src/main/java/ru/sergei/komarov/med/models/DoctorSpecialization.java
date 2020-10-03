package ru.sergei.komarov.med.models;

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
    private String name;

    @OneToMany(mappedBy = "specialization")
    private List<Doctor> doctors;

}
