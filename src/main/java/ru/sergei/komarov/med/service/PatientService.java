package ru.sergei.komarov.med.service;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.model.User;
import ru.sergei.komarov.med.repository.PatientRepository;

@Service
public class PatientService extends BasicDataService<Patient, Integer> {
    public PatientService(PatientRepository repository) {
        super(repository);
    }

    public Patient getByUser(User user) {
        return ((PatientRepository) repository).findByUser(user);
    }
}
