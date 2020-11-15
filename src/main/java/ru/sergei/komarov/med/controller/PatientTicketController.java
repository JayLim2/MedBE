package ru.sergei.komarov.med.controller;

import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.exception.DoctorNotFoundException;
import ru.sergei.komarov.med.exception.PatientNotFoundException;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.model.PatientTicket;
import ru.sergei.komarov.med.service.DoctorService;
import ru.sergei.komarov.med.service.PatientService;
import ru.sergei.komarov.med.service.PatientTicketService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/patientTickets")
public class PatientTicketController extends BasicDataController<PatientTicket, Integer> {
    private final DoctorService doctorService;
    private final PatientService patientService;

    public PatientTicketController(PatientTicketService service, DoctorService doctorService, PatientService patientService) {
        super(service);
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    /* Custom get requests */

    //Patient

    @GetMapping("/get/patient/{patientId}")
    public List<PatientTicket> getByPatient(@PathVariable int patientId) {
        Patient patient = patientService.getById(patientId);
        if (patient == null) {
            throw new PatientNotFoundException(patientId);
        }
        return ((PatientTicketService) service).getByPatient(patient);
    }

    @GetMapping("/get/patient/datetime/{patientId}")
    public List<PatientTicket> getByPatientAndDateTime(@PathVariable int patientId,
                                                       @RequestParam LocalDateTime from,
                                                       @RequestParam LocalDateTime to) {
        Patient patient = patientService.getById(patientId);
        if (patient == null) {
            throw new PatientNotFoundException(patientId);
        }
        return ((PatientTicketService) service).getByPatientAndDateTimeBetween(patient, from, to);
    }

    //Doctor

    @GetMapping("/get/doctor/{doctorId}")
    public List<PatientTicket> getByDoctor(@PathVariable int doctorId) {
        Doctor doctor = doctorService.getById(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        return ((PatientTicketService) service).getByDoctor(doctor);
    }

    @GetMapping("/get/doctor/datetime/{doctorId}")
    public List<PatientTicket> getByDoctorAndDateTime(@PathVariable int doctorId,
                                                      @RequestParam LocalDateTime from,
                                                      @RequestParam LocalDateTime to) {
        Doctor doctor = doctorService.getById(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        return ((PatientTicketService) service).getByDoctorAndDateTimeBetween(doctor, from, to);
    }

    // Patient && Doctor

    @GetMapping("/get/patientAndDoctor/{patientId}/{doctorId}")
    public List<PatientTicket> getByPatientAndDoctor(@PathVariable int patientId, @PathVariable int doctorId) {
        Patient patient = patientService.getById(patientId);
        if (patient == null) {
            throw new PatientNotFoundException(patientId);
        }
        Doctor doctor = doctorService.getById(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        return ((PatientTicketService) service).getByPatientAndDoctor(patient, doctor);
    }

    @GetMapping("/get/patientAndDoctor/datetime/{patientId}/{doctorId}")
    public List<PatientTicket> getByPatientAndDoctorAndDateTime(@PathVariable int patientId,
                                                                @PathVariable int doctorId,
                                                                @RequestParam LocalDateTime from,
                                                                @RequestParam LocalDateTime to) {
        Patient patient = patientService.getById(patientId);
        if (patient == null) {
            throw new PatientNotFoundException(patientId);
        }
        Doctor doctor = doctorService.getById(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        return ((PatientTicketService) service).getByPatientAndDoctorAndDateTimeBetween(patient, doctor, from, to);
    }
}
