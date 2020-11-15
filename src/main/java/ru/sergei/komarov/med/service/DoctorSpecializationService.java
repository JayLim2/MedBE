package ru.sergei.komarov.med.service;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.DoctorSpecialization;
import ru.sergei.komarov.med.repository.DoctorSpecializationRepository;

@Service
public class DoctorSpecializationService extends BasicDataService<DoctorSpecialization, String> {
    public DoctorSpecializationService(DoctorSpecializationRepository repository) {
        super(repository);
    }
}
