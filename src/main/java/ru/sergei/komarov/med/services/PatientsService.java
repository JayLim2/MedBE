package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.Patient;
import ru.sergei.komarov.med.models.User;
import ru.sergei.komarov.med.repositories.PatientsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientsService implements BasicDataService<Patient, Integer> {

    private final PatientsRepository patientsRepository;

    @Override
    public Patient getById(Integer integer) {
        return patientsRepository.findById(integer).orElse(null);
    }

    @Override
    public List<Patient> getAll() {
        return (List<Patient>)patientsRepository.findAll();
    }

    @Override
    public void save(Patient item) {
        patientsRepository.save(item);
    }

    @Override
    public void saveList(List<Patient> items) {
        patientsRepository.saveAll(items);
    }

    @Override
    public void deleteById(Integer integer) {
        patientsRepository.deleteById(integer);
    }

    @Override
    public void delete(Patient item) {
        patientsRepository.delete(item);
    }

    @Override
    public void deleteAll() {
        patientsRepository.deleteAll();
    }

    public Patient getByUser(User user) {
        return patientsRepository.findByUser(user);
    }

}
