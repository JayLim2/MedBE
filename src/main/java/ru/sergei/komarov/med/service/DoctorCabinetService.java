package ru.sergei.komarov.med.service;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.DoctorCabinet;
import ru.sergei.komarov.med.repository.DoctorCabinetRepository;

@Service
public class DoctorCabinetService extends BasicDataService<DoctorCabinet, String> {
    public DoctorCabinetService(DoctorCabinetRepository repository) {
        super(repository);
    }
}
