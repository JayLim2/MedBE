package ru.sergei.komarov.med.service;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.DoctorSpecialization;
import ru.sergei.komarov.med.repository.DoctorSpecializationRepository;

@Service
public class DoctorSpecializationService extends BasicDataService<DoctorSpecialization, Integer> {
    public DoctorSpecializationService(DoctorSpecializationRepository repository) {
        super(repository);
    }

    public DoctorSpecialization getByName(String name) {
        return ((DoctorSpecializationRepository)repository).findByName(name);
    }
}
