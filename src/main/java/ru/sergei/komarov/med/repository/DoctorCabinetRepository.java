package ru.sergei.komarov.med.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.model.DoctorCabinet;

public interface DoctorCabinetRepository extends CrudRepository<DoctorCabinet, String> {
}
