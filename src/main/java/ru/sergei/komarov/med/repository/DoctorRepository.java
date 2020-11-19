package ru.sergei.komarov.med.repository;

import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.DoctorSpecialization;
import ru.sergei.komarov.med.model.MedicalService;

import java.util.List;

public interface DoctorRepository extends UserRepository<Doctor> {
    List<Doctor> findBySpecialization(DoctorSpecialization specialization);

    List<Doctor> findByMedicalServicesContains(MedicalService medicalService);
}
