package ru.sergei.komarov.med.controller.data;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.model.PatientTicket;
import ru.sergei.komarov.med.model.Role;
import ru.sergei.komarov.med.service.PatientTicketService;
import ru.sergei.komarov.med.service.user.DoctorService;
import ru.sergei.komarov.med.service.user.PatientService;
import ru.sergei.komarov.med.util.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PatientTicket> getAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Role role = authentication.getAuthorities().stream().map(a -> Role.valueOf(a.getAuthority())).collect(Collectors.toList()).get(0);
        Integer userId = Integer.parseInt(((UserDetails) authentication.getPrincipal()).getUsername());
        List<PatientTicket> tickets;
        switch (role) {
            case PATIENT:
                tickets = getByPatient(userId);
                break;
            case DOCTOR:
                tickets = getByDoctor(userId);
                break;
            case ADMIN:
                tickets = super.getAll();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + role);
        }
        return tickets;
    }

    /* Custom get requests */

    //Patient

    @GetMapping("/get/patient/{patientId}")
    public List<PatientTicket> getByPatient(@PathVariable Integer patientId) {
        Patient patient = patientService.getById(patientId);
        Utils.requireNonNull(patient);
        return ((PatientTicketService) service).getByPatient(patient);
    }

    @GetMapping("/get/patient/datetime/{patientId}")
    public List<PatientTicket> getByPatientAndDateTime(@PathVariable Integer patientId,
                                                       @RequestParam LocalDateTime from,
                                                       @RequestParam LocalDateTime to) {
        Patient patient = patientService.getById(patientId);
        Utils.requireNonNull(patient);
        return ((PatientTicketService) service).getByPatientAndDateTimeBetween(patient, from, to);
    }

    //Doctor

    @GetMapping("/get/doctor/{doctorId}")
    public List<PatientTicket> getByDoctor(@PathVariable Integer doctorId) {
        Doctor doctor = doctorService.getById(doctorId);
        Utils.requireNonNull(doctor);
        return ((PatientTicketService) service).getByDoctor(doctor);
    }

    @GetMapping("/get/doctor/datetime/{doctorId}")
    public List<PatientTicket> getByDoctorAndDateTime(@PathVariable Integer doctorId,
                                                      @RequestParam LocalDateTime from,
                                                      @RequestParam LocalDateTime to) {
        Doctor doctor = doctorService.getById(doctorId);
        Utils.requireNonNull(doctor);
        return ((PatientTicketService) service).getByDoctorAndDateTimeBetween(doctor, from, to);
    }

    // Patient && Doctor

    @GetMapping("/get/patientAndDoctor/{patientId}/{doctorId}")
    public List<PatientTicket> getByPatientAndDoctor(@PathVariable Integer patientId, @PathVariable Integer doctorId) {
        Patient patient = patientService.getById(patientId);
        Utils.requireNonNull(patient);
        Doctor doctor = doctorService.getById(doctorId);
        Utils.requireNonNull(doctor);
        return ((PatientTicketService) service).getByPatientAndDoctor(patient, doctor);
    }

    @GetMapping("/get/patientAndDoctor/datetime/{patientId}/{doctorId}")
    public List<PatientTicket> getByPatientAndDoctorAndDateTime(@PathVariable Integer patientId,
                                                                @PathVariable Integer doctorId,
                                                                @RequestParam LocalDateTime from,
                                                                @RequestParam LocalDateTime to) {
        Patient patient = patientService.getById(patientId);
        Utils.requireNonNull(patient);
        Doctor doctor = doctorService.getById(doctorId);
        Utils.requireNonNull(doctor);
        return ((PatientTicketService) service).getByPatientAndDoctorAndDateTimeBetween(patient, doctor, from, to);
    }

    @GetMapping("/get/doctor/date/{doctorId}/")
    public List<LocalDateTime> getFreeTimeListForDate(@PathVariable Integer doctorId, @RequestParam LocalDate date) {
        Doctor doctor = doctorService.getById(doctorId);
        Utils.requireNonNull(doctor);
        return ((PatientTicketService) service).getFreeTimeListForDate(doctor, date);
    }
}
