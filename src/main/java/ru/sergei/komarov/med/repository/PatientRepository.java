package ru.sergei.komarov.med.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.model.User;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

    Patient findByUser(User user);

}
