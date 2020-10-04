package ru.sergei.komarov.med.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.models.Doctor;
import ru.sergei.komarov.med.models.DoctorSpecialization;
import ru.sergei.komarov.med.models.User;

import java.util.List;

public interface DoctorsRepository extends CrudRepository<Doctor, Integer> {

    List<Doctor> findBySpecialization(DoctorSpecialization specialization);

    Doctor findByUser(User user);

}
