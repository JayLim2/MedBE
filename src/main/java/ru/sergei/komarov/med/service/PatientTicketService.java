package ru.sergei.komarov.med.service;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.model.PatientTicket;
import ru.sergei.komarov.med.repository.PatientTicketRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PatientTicketService extends BasicDataService<PatientTicket, Integer> {
    private final LocalTime startWorkingTime = LocalTime.parse("08");
    private final LocalTime endWorkingTime = LocalTime.parse("20");
    private final List<LocalTime> possibleTicketTimes = new ArrayList<>();

    public PatientTicketService(PatientTicketRepository repository) {
        super(repository);
        LocalTime possibleTime = startWorkingTime;
        while (!possibleTime.isAfter(endWorkingTime)) {
            possibleTicketTimes.add(possibleTime);
            possibleTime = possibleTime.plusMinutes(30);
        }
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

    public List<LocalDateTime> getFreeTimeListForDate(Doctor doctor, LocalDate date) {
        if (date.getDayOfWeek().getValue() >= 6) {
            return Collections.emptyList();
        }
        List<LocalDateTime> freeTimes = createDataTimes(date, possibleTicketTimes);
        List<PatientTicket> tickets = ((PatientTicketRepository) repository).findByDoctorAndDateTimeBetween(
                doctor,
                date.atTime(startWorkingTime),
                date.atTime(endWorkingTime)
        );
        for (PatientTicket ticket : tickets) {
            freeTimes.remove(ticket.getDateTime());
        }
        return freeTimes;
    }

    private List<LocalDateTime> createDataTimes(LocalDate date, List<LocalTime> times) {
        List<LocalDateTime> localDateTimes = new ArrayList<>();
        for (LocalTime time : times) {
            localDateTimes.add(LocalDateTime.of(date, time));
        }
        return localDateTimes;
    }
}
