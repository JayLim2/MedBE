package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.Doctor;
import ru.sergei.komarov.med.repositories.DoctorsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorsService implements BasicDataService<Doctor, Integer> {

    private final DoctorsRepository doctorsRepository;

    @Override
    public Doctor getById(Integer integer) {
        return null;
    }

    @Override
    public List<Doctor> getAll() {
        return null;
    }

    @Override
    public void save(Doctor item) {

    }

    @Override
    public void saveAll(List<Doctor> items) {

    }

    @Override
    public void delete(Doctor item) {

    }
}
