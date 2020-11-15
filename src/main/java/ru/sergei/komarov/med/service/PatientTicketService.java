package ru.sergei.komarov.med.service;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.model.PatientTicket;
import ru.sergei.komarov.med.repository.PatientTicketRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatientTicketService extends BasicDataService<PatientTicket, Integer> {
    public PatientTicketService(PatientTicketRepository repository) {
        super(repository);
    }

    public List<PatientTicket> getByPatient(Patient patient) {
        return ((PatientTicketRepository) repository).findByPatient(patient);
    }

    public List<PatientTicket> getByDoctor(Doctor doctor) {
        return ((PatientTicketRepository) repository).findByDoctor(doctor);
    }

    public List<PatientTicket> getByPatientAndDoctor(Patient patient, Doctor doctor) {
        return ((PatientTicketRepository) repository).findByPatientAndDoctor(patient, doctor);
    }

    public List<PatientTicket> getByPatientAndDateTimeBetween(Patient patient, LocalDateTime from, LocalDateTime to) {
        return ((PatientTicketRepository) repository).findByPatientAndDateTimeBetween(patient, from, to);
    }

    public List<PatientTicket> getByDoctorAndDateTimeBetween(Doctor doctor, LocalDateTime from, LocalDateTime to) {
        return ((PatientTicketRepository) repository).findByDoctorAndDateTimeBetween(doctor, from, to);
    }

    public List<PatientTicket> getByPatientAndDoctorAndDateTimeBetween(Patient patient, Doctor doctor, LocalDateTime from, LocalDateTime to) {
        return ((PatientTicketRepository) repository).findByPatientAndDoctorAndDateTimeBetween(patient, doctor, from, to);
    }
}
