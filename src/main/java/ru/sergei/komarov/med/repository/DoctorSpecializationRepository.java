package ru.sergei.komarov.med.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.model.DoctorSpecialization;

public interface DoctorSpecializationRepository extends CrudRepository<DoctorSpecialization, Integer> {
    DoctorSpecialization findByName(String name);
}
