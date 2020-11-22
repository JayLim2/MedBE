package ru.sergei.komarov.med.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.model.DoctorSpecialization;

import java.util.Set;

public interface DoctorSpecializationRepository extends CrudRepository<DoctorSpecialization, Integer> {
    @Query("select ds, d from DoctorSpecialization ds inner join ds.doctors d")
    Set<DoctorSpecialization> findAllAvailable();

    DoctorSpecialization findByName(String name);
}
