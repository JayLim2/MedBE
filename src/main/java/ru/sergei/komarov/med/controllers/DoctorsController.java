package ru.sergei.komarov.med.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.services.DoctorsService;

@RestController
@RequestMapping("/api/doctors")
@AllArgsConstructor
public class DoctorsController {

    private final DoctorsService doctorsService;

}
