package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.Doctor;
import ru.sergei.komarov.med.models.DoctorSpecialization;
import ru.sergei.komarov.med.models.User;
import ru.sergei.komarov.med.repositories.DoctorsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorsService implements BasicDataService<Doctor, Integer> {

    private final DoctorsRepository doctorsRepository;

    @Override
    public Doctor getById(Integer integer) {
        return doctorsRepository.findById(integer).orElse(null);
    }

    @Override
    public List<Doctor> getAll() {
        return (List<Doctor>)doctorsRepository.findAll();
    }

    @Override
    public void save(Doctor item) {
        doctorsRepository.save(item);
    }

    @Override
    public void saveList(List<Doctor> items) {
        doctorsRepository.saveAll(items);
    }

    @Override
    public void deleteById(Integer integer) {
        doctorsRepository.deleteById(integer);
    }

    @Override
    public void delete(Doctor item) {
        doctorsRepository.delete(item);
    }

    @Override
    public void deleteAll() {
        doctorsRepository.deleteAll();
    }

    public List<Doctor> getBySpecialization(DoctorSpecialization specialization) {
        return doctorsRepository.findBySpecialization(specialization);
    }

    public Doctor getByUser(User user) {
        return doctorsRepository.findByUser(user);
    }
}
