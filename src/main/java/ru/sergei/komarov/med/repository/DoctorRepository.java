package ru.sergei.komarov.med.repository;

import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.DoctorSpecialization;

import java.util.List;

public interface DoctorRepository extends UserRepository<Doctor> {
    List<Doctor> findBySpecialization(DoctorSpecialization specialization);
}
