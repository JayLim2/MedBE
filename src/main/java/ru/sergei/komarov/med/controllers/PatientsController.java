package ru.sergei.komarov.med.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.services.PatientsService;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientsController {

    private final PatientsService patientsService;

}
