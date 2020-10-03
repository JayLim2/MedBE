package ru.sergei.komarov.med.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.models.PatientTicket;

public interface PatientTicketsRepository extends CrudRepository<PatientTicket, Integer> {
}
