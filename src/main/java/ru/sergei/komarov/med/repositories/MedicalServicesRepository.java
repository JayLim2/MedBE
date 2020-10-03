package ru.sergei.komarov.med.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.models.MedicalService;

public interface MedicalServicesRepository extends CrudRepository<MedicalService, String> {
}
