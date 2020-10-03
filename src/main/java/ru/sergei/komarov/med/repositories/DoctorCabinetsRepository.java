package ru.sergei.komarov.med.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.models.DoctorCabinet;

public interface DoctorCabinetsRepository extends CrudRepository<DoctorCabinet, String> {
}
