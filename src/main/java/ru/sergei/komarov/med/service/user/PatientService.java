package ru.sergei.komarov.med.service.user;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.repository.PatientRepository;

@Service
public class PatientService extends BasicUserService<Patient> {
    public PatientService(PatientRepository repository) {
        super(repository);
    }
}
