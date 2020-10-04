package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.Doctor;
import ru.sergei.komarov.med.models.Patient;
import ru.sergei.komarov.med.models.PatientTicket;
import ru.sergei.komarov.med.repositories.PatientTicketsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PatientTicketsService implements BasicDataService<PatientTicket, Integer> {

    private final PatientTicketsRepository patientTicketsRepository;

    @Override
    public PatientTicket getById(Integer integer) {
        return patientTicketsRepository.findById(integer).orElse(null);
    }

    @Override
    public List<PatientTicket> getAll() {
        return (List<PatientTicket>) patientTicketsRepository.findAll();
    }

    @Override
    public void save(PatientTicket item) {
        patientTicketsRepository.save(item);
    }

    @Override
    public void saveList(List<PatientTicket> items) {
        patientTicketsRepository.saveAll(items);
    }

    @Override
    public void deleteById(Integer integer) {
        patientTicketsRepository.deleteById(integer);
    }

    @Override
    public void delete(PatientTicket item) {
        patientTicketsRepository.delete(item);
    }

    @Override
    public void deleteAll() {
        patientTicketsRepository.deleteAll();
    }

    public List<PatientTicket> getByPatient(Patient patient) {
        return patientTicketsRepository.findByPatient(patient);
    }

    public List<PatientTicket> getByDoctor(Doctor doctor) {
        return patientTicketsRepository.findByDoctor(doctor);
    }

    public List<PatientTicket> getByPatientAndDoctor(Patient patient, Doctor doctor) {
        return patientTicketsRepository.findByPatientAndDoctor(patient, doctor);
    }

    public List<PatientTicket> getByPatientAndDateTimeBetween(Patient patient,
                                                              LocalDateTime from, LocalDateTime to) {

        return patientTicketsRepository.findByPatientAndDateTimeBetween(patient, from, to);
    }

    public List<PatientTicket> getByDoctorAndDateTimeBetween(Doctor doctor,
                                                             LocalDateTime from, LocalDateTime to) {

        return patientTicketsRepository.findByDoctorAndDateTimeBetween(doctor, from, to);
    }

    public List<PatientTicket> getByPatientAndDoctorAndDateTimeBetween(Patient patient, Doctor doctor,
                                                                       LocalDateTime from, LocalDateTime to) {

        return patientTicketsRepository.findByPatientAndDoctorAndDateTimeBetween(patient, doctor, from, to);
    }
}
