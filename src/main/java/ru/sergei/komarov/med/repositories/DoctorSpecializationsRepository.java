package ru.sergei.komarov.med.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.models.DoctorSpecialization;

public interface DoctorSpecializationsRepository extends CrudRepository<DoctorSpecialization, String> {
}
