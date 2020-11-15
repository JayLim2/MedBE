package ru.sergei.komarov.med.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.model.PatientTicket;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientTicketRepository extends CrudRepository<PatientTicket, Integer> {

    // Patient

    List<PatientTicket> findByPatient(Patient patient);

    List<PatientTicket> findByPatientAndDateTimeBetween(Patient patient, LocalDateTime from, LocalDateTime to);

    //Doctor

    List<PatientTicket> findByDoctor(Doctor doctor);

    List<PatientTicket> findByDoctorAndDateTimeBetween(Doctor doctor, LocalDateTime from, LocalDateTime to);

    //Patient && Doctor

    List<PatientTicket> findByPatientAndDoctor(Patient patient, Doctor doctor);

    List<PatientTicket> findByPatientAndDoctorAndDateTimeBetween(Patient patient, Doctor doctor, LocalDateTime from, LocalDateTime to);

}
