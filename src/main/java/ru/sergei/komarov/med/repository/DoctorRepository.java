package ru.sergei.komarov.med.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.DoctorSpecialization;
import ru.sergei.komarov.med.model.User;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    List<Doctor> findBySpecialization(DoctorSpecialization specialization);

    Doctor findByUser(User user);

}
