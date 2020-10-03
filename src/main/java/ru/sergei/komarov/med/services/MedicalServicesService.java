package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.MedicalService;
import ru.sergei.komarov.med.repositories.MedicalServicesRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicalServicesService implements BasicDataService<MedicalService, String> {

    private final MedicalServicesRepository medicalServicesRepository;

    @Override
    public MedicalService getById(String s) {
        return null;
    }

    @Override
    public List<MedicalService> getAll() {
        return null;
    }

    @Override
    public void save(MedicalService item) {

    }

    @Override
    public void saveAll(List<MedicalService> items) {

    }

    @Override
    public void delete(MedicalService item) {

    }
}
