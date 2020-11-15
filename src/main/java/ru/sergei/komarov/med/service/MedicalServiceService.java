package ru.sergei.komarov.med.service;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.MedicalService;
import ru.sergei.komarov.med.repository.MedicalServiceRepository;

import java.util.List;

@Service
public class MedicalServiceService extends BasicDataService<MedicalService, String> {
    public MedicalServiceService(MedicalServiceRepository repository) {
        super(repository);
    }

    public List<MedicalService> getByDoctor(Doctor doctor) {
        return ((MedicalServiceRepository) repository).findByDoctorsContains(doctor);
    }

    public List<MedicalService> getByNameIn(List<String> names) {
        return ((MedicalServiceRepository) repository).findByNameIn(names);
    }
}
