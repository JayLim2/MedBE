package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.DoctorCabinet;
import ru.sergei.komarov.med.repositories.DoctorCabinetsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorCabinetsService implements BasicDataService<DoctorCabinet, String> {

    private final DoctorCabinetsRepository doctorCabinetsRepository;

    @Override
    public DoctorCabinet getById(String s) {
        return doctorCabinetsRepository.findById(s).orElse(null);
    }

    @Override
    public List<DoctorCabinet> getAll() {
        return (List<DoctorCabinet>) doctorCabinetsRepository.findAll();
    }

    @Override
    public void save(DoctorCabinet item) {
        doctorCabinetsRepository.save(item);
    }

    @Override
    public void saveList(List<DoctorCabinet> items) {
        doctorCabinetsRepository.saveAll(items);
    }

    @Override
    public void deleteById(String s) {
        doctorCabinetsRepository.deleteById(s);
    }

    @Override
    public void delete(DoctorCabinet item) {
        doctorCabinetsRepository.delete(item);
    }

    @Override
    public void deleteAll() {
        doctorCabinetsRepository.deleteAll();
    }

}
