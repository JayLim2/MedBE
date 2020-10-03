package ru.sergei.komarov.med.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.services.DoctorSpecializationsService;

@RestController
@RequestMapping("/api/doctorSpecializations")
@AllArgsConstructor
public class DoctorSpecializationsController {

    private final DoctorSpecializationsService doctorSpecializationsService;

}
