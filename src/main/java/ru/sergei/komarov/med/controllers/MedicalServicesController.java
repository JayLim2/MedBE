package ru.sergei.komarov.med.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.services.MedicalServicesService;

@RestController
@RequestMapping("/api/medicalServices")
@AllArgsConstructor
public class MedicalServicesController {

    private final MedicalServicesService medicalServicesService;

}
