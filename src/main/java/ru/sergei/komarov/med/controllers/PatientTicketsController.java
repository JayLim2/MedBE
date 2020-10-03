package ru.sergei.komarov.med.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.services.PatientTicketsService;

@RestController
@RequestMapping("/api/patientTickets")
@AllArgsConstructor
public class PatientTicketsController {

    private final PatientTicketsService patientTicketsService;

    @GetMapping("/{patientId}")
    public JsonArray getByPatient(@PathVariable int patientId) {
        return new JsonArray();
    }

    @GetMapping("/all")
    public JsonArray getAll() {
        return new JsonArray();
    }

    @PostMapping("/save")
    public void save(JsonObject jsonPatientTicket) {

    }

    @DeleteMapping("/delete/{patientTicketId}")
    public void delete(@PathVariable int patientTicketId) {

    }

}
