package ru.sergei.komarov.med.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.models.Patient;
import ru.sergei.komarov.med.models.User;

public interface PatientsRepository extends CrudRepository<Patient, Integer> {

    Patient findByUser(User user);

}
