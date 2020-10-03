package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.DoctorSpecialization;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorSpecializationsService implements BasicDataService<DoctorSpecialization, String>  {

    @Override
    public DoctorSpecialization getById(String s) {
        return null;
    }

    @Override
    public List<DoctorSpecialization> getAll() {
        return null;
    }

    @Override
    public void save(DoctorSpecialization item) {

    }

    @Override
    public void saveAll(List<DoctorSpecialization> items) {

    }

    @Override
    public void delete(DoctorSpecialization item) {

    }
}
