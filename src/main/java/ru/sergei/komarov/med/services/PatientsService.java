package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.Patient;
import ru.sergei.komarov.med.repositories.PatientsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientsService implements BasicDataService<Patient, Integer> {

    private final PatientsRepository patientsRepository;

    @Override
    public Patient getById(Integer integer) {
        return null;
    }

    @Override
    public List<Patient> getAll() {
        return null;
    }

    @Override
    public void save(Patient item) {

    }

    @Override
    public void saveAll(List<Patient> items) {

    }

    @Override
    public void delete(Patient item) {

    }
}
