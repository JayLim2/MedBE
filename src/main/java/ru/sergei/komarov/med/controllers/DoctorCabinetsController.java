package ru.sergei.komarov.med.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.services.DoctorCabinetsService;

@RestController
@RequestMapping("/api/doctorCabinets")
@AllArgsConstructor
public class DoctorCabinetsController {

    private final DoctorCabinetsService doctorCabinetsService;

}
