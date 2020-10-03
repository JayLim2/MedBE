package ru.sergei.komarov.med.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.models.Patient;

public interface PatientsRepository extends CrudRepository<Patient, Integer> {
}
