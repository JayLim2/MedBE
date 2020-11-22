package ru.sergei.komarov.med.service;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.model.PatientTicket;
import ru.sergei.komarov.med.repository.PatientTicketRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientTicketService extends BasicDataService<PatientTicket, Integer> {
    private final LocalTime startWorkingTime = LocalTime.parse("08:00");
    private final LocalTime endWorkingTime = LocalTime.parse("20:00");
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
        List<LocalDateTime> freeTimes = createDateTimes(date, possibleTicketTimes);
        if (freeTimes.size() > 0) {
            List<PatientTicket> tickets = ((PatientTicketRepository) repository).findByDoctorAndDateTimeBetween(
                    doctor,
                    freeTimes.get(0),
                    freeTimes.get(freeTimes.size() - 1)
            );
            for (PatientTicket ticket : tickets) {
                freeTimes.remove(ticket.getDateTime());
            }
        }
        return freeTimes;
    }

    private List<LocalDateTime> createDateTimes(LocalDate date, List<LocalTime> times) {
        int periodCount = 14;
        int currentDay = date.getDayOfWeek().getValue();
        if (currentDay >= 6) {
            date = date.plusWeeks(1).with(DayOfWeek.MONDAY);
        }

        List<LocalDateTime> localDateTimes = new ArrayList<>();
        for (int i = 0; i < periodCount; i++) {
            if (date.getDayOfWeek().getValue() < 6) {
                for (LocalTime time : times) {
                    localDateTimes.add(LocalDateTime.of(date, time));
                }
            }
            date = date.plusDays(1);
        }

        return localDateTimes;
    }
}
