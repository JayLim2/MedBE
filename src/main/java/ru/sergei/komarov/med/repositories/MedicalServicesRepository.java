package ru.sergei.komarov.med.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.models.Doctor;
import ru.sergei.komarov.med.models.MedicalService;

import java.util.List;

public interface MedicalServicesRepository extends CrudRepository<MedicalService, String> {

    List<MedicalService> findByDoctorsContains(Doctor doctor);

    List<MedicalService> findByNameIn(List<String> ids);

}
