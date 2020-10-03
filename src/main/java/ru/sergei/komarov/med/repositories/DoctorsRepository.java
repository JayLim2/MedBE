package ru.sergei.komarov.med.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.models.Doctor;

public interface DoctorsRepository extends CrudRepository<Doctor, Integer> {
}
