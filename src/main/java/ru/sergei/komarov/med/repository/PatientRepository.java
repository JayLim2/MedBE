package ru.sergei.komarov.med.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

    //Patient findByUser(User user);

}
