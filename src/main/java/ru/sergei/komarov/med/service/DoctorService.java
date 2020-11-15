package ru.sergei.komarov.med.service;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.DoctorSpecialization;
import ru.sergei.komarov.med.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService extends BasicDataService<Doctor, Integer> {
    public DoctorService(DoctorRepository repository) {
        super(repository);
    }

    public List<Doctor> getBySpecialization(DoctorSpecialization specialization) {
        return ((DoctorRepository) repository).findBySpecialization(specialization);
    }

/*    public Doctor getByUser(User user) {
        return ((DoctorRepository) repository).findByUser(user);
    }*/
}
