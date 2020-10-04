package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.DoctorSpecialization;
import ru.sergei.komarov.med.repositories.DoctorSpecializationsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorSpecializationsService implements BasicDataService<DoctorSpecialization, String>  {

    private final DoctorSpecializationsRepository doctorSpecializationsRepository;

    @Override
    public DoctorSpecialization getById(String s) {
        return doctorSpecializationsRepository.findById(s).orElse(null);
    }

    @Override
    public List<DoctorSpecialization> getAll() {
        return (List<DoctorSpecialization>) doctorSpecializationsRepository.findAll();
    }

    @Override
    public void save(DoctorSpecialization item) {
        doctorSpecializationsRepository.save(item);
    }

    @Override
    public void saveList(List<DoctorSpecialization> items) {
        doctorSpecializationsRepository.saveAll(items);
    }

    @Override
    public void deleteById(String s) {
        doctorSpecializationsRepository.deleteById(s);
    }

    @Override
    public void delete(DoctorSpecialization item) {
        doctorSpecializationsRepository.delete(item);
    }

    @Override
    public void deleteAll() {
        doctorSpecializationsRepository.deleteAll();
    }
}
