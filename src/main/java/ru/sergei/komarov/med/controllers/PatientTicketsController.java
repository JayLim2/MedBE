package ru.sergei.komarov.med.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.exceptions.DoctorNotFoundException;
import ru.sergei.komarov.med.exceptions.PatientNotFoundException;
import ru.sergei.komarov.med.models.Doctor;
import ru.sergei.komarov.med.models.Patient;
import ru.sergei.komarov.med.models.PatientTicket;
import ru.sergei.komarov.med.services.DoctorsService;
import ru.sergei.komarov.med.services.PatientTicketsService;
import ru.sergei.komarov.med.services.PatientsService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/patientTickets")
@AllArgsConstructor
public class PatientTicketsController implements BasicDataController<PatientTicket, Integer> {

    private final DoctorsService doctorsService;
    private final PatientsService patientsService;
    private final PatientTicketsService patientTicketsService;

    @GetMapping("/get/{id}")
    public JsonObject getById(@PathVariable Integer id) {
        PatientTicket patientTicket = patientTicketsService.getById(id);
        return null;
    }

    /* Custom get requests */

    //Patient

    @GetMapping("/get/patient/{patientId}")
    public JsonArray getByPatient(@PathVariable int patientId) {
        Patient patient = patientsService.getById(patientId);
        if (patient == null) {
            throw new PatientNotFoundException(patientId);
        }
        List<PatientTicket> patientTickets = patientTicketsService.getByPatient(patient);
        return null;
    }

    @GetMapping("/get/patient/datetime/{patientId}")
    public JsonArray getByPatientAndDateTime(@PathVariable int patientId,
                                             @RequestParam LocalDateTime from,
                                             @RequestParam LocalDateTime to) {

        Patient patient = patientsService.getById(patientId);
        if (patient == null) {
            throw new PatientNotFoundException(patientId);
        }
        List<PatientTicket> patientTickets = patientTicketsService.getByPatientAndDateTimeBetween(patient, from, to);
        return null;
    }

    //Doctor

    @GetMapping("/get/doctor/{doctorId}")
    public JsonArray getByDoctor(@PathVariable int doctorId) {
        Doctor doctor = doctorsService.getById(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        List<PatientTicket> patientTickets = patientTicketsService.getByDoctor(doctor);
        return null;
    }

    @GetMapping("/get/doctor/datetime/{doctorId}")
    public JsonArray getByDoctorAndDateTime(@PathVariable int doctorId,
                                            @RequestParam LocalDateTime from,
                                            @RequestParam LocalDateTime to) {

        Doctor doctor = doctorsService.getById(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        List<PatientTicket> patientTickets = patientTicketsService.getByDoctorAndDateTimeBetween(doctor, from, to);
        return null;
    }

    // Patient && Doctor

    @GetMapping("/get/patientAndDoctor/{patientId}/{doctorId}")
    public JsonArray getByPatientAndDoctor(@PathVariable int patientId, @PathVariable int doctorId) {
        Patient patient = patientsService.getById(patientId);
        if (patient == null) {
            throw new PatientNotFoundException(patientId);
        }
        Doctor doctor = doctorsService.getById(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        List<PatientTicket> patientTickets = patientTicketsService.getByPatientAndDoctor(patient, doctor);
        return null;
    }

    @GetMapping("/get/patientAndDoctor/datetime/{patientId}/{doctorId}")
    public JsonArray getByPatientAndDoctorAndDateTime(@PathVariable int patientId,
                                                      @PathVariable int doctorId,
                                                      @RequestParam LocalDateTime from,
                                                      @RequestParam LocalDateTime to) {

        Patient patient = patientsService.getById(patientId);
        if (patient == null) {
            throw new PatientNotFoundException(patientId);
        }
        Doctor doctor = doctorsService.getById(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        List<PatientTicket> patientTickets = patientTicketsService.getByPatientAndDoctorAndDateTimeBetween(patient, doctor, from, to);
        return null;
    }

    /* -------------------------- */

    @GetMapping("/get/all")
    public JsonArray getAll() {
        List<PatientTicket> patientTickets = patientTicketsService.getAll();
        return new JsonArray();
    }

    @PutMapping("/save")
    public JsonElement save(JsonObject jsonPatientTicket) {
        return null;
    }

    @PutMapping("/save/list")
    public JsonElement saveList(JsonArray jsonArray) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public JsonElement deleteById(@PathVariable Integer id) {
        patientTicketsService.deleteById(id);
        return null;
    }

    @DeleteMapping("/delete/all")
    public JsonElement deleteAll() {
        patientTicketsService.deleteAll();
        return null;
    }

}
