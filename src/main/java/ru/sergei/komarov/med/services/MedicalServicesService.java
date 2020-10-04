package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.Doctor;
import ru.sergei.komarov.med.models.MedicalService;
import ru.sergei.komarov.med.repositories.MedicalServicesRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicalServicesService implements BasicDataService<MedicalService, String> {

    private final MedicalServicesRepository medicalServicesRepository;

    @Override
    public MedicalService getById(String s) {
        return medicalServicesRepository.findById(s).orElse(null);
    }

    @Override
    public List<MedicalService> getAll() {
        return (List<MedicalService>)medicalServicesRepository.findAll();
    }

    @Override
    public void save(MedicalService item) {
        medicalServicesRepository.save(item);
    }

    @Override
    public void saveList(List<MedicalService> items) {
        medicalServicesRepository.saveAll(items);
    }

    @Override
    public void deleteById(String s) {
        medicalServicesRepository.deleteById(s);
    }

    @Override
    public void delete(MedicalService item) {
        medicalServicesRepository.delete(item);
    }

    @Override
    public void deleteAll() {
        medicalServicesRepository.deleteAll();
    }

    public List<MedicalService> getByDoctor(Doctor doctor) {
        return medicalServicesRepository.findByDoctorsContains(doctor);
    }

    public List<MedicalService> getByNameIn(List<String> names) {
        return medicalServicesRepository.findByNameIn(names);
    }
}
