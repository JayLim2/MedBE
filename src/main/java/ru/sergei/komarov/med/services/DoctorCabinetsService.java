package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.DoctorCabinet;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorCabinetsService implements BasicDataService<DoctorCabinet, String> {

    @Override
    public DoctorCabinet getById(String s) {
        return null;
    }

    @Override
    public List<DoctorCabinet> getAll() {
        return null;
    }

    @Override
    public void save(DoctorCabinet item) {

    }

    @Override
    public void saveAll(List<DoctorCabinet> items) {

    }

    @Override
    public void delete(DoctorCabinet item) {

    }
}
