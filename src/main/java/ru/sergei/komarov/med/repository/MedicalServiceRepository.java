package ru.sergei.komarov.med.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.MedicalService;

import java.util.List;

public interface MedicalServiceRepository extends CrudRepository<MedicalService, String> {

    List<MedicalService> findByDoctorsContains(Doctor doctor);

    List<MedicalService> findByNameIn(List<String> ids);

}
