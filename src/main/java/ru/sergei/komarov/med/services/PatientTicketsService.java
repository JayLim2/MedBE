package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.PatientTicket;
import ru.sergei.komarov.med.repositories.PatientTicketsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientTicketsService implements BasicDataService<PatientTicket, Integer> {

    private final PatientTicketsRepository patientTicketsRepository;

    @Override
    public PatientTicket getById(Integer integer) {
        return null;
    }

    @Override
    public List<PatientTicket> getAll() {
        return null;
    }

    @Override
    public void save(PatientTicket item) {

    }

    @Override
    public void saveAll(List<PatientTicket> items) {

    }

    @Override
    public void delete(PatientTicket item) {

    }
}
