package ru.sergei.komarov.med.service.user;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.DoctorSpecialization;
import ru.sergei.komarov.med.model.MedicalService;
import ru.sergei.komarov.med.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService extends BasicUserService<Doctor> {
    public DoctorService(DoctorRepository repository) {
        super(repository);
    }

    public List<Doctor> getBySpecialization(DoctorSpecialization specialization) {
        return ((DoctorRepository) repository).findBySpecialization(specialization);
    }

    public List<Doctor> getByMedicalService(MedicalService medicalService) {
        return ((DoctorRepository) repository).findByMedicalServicesContains(medicalService);
    }
}
