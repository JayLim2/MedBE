package ru.sergei.komarov.med.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.sergei.komarov.med.exception.DoctorNotFoundException;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.MedicalService;
import ru.sergei.komarov.med.service.DoctorService;
import ru.sergei.komarov.med.service.MedicalServiceService;

import java.util.List;

@Controller
public class MedicalServiceController extends BasicDataController<MedicalService, String> {
    private final DoctorService doctorsService;

    public MedicalServiceController(MedicalServiceService service, DoctorService doctorsService) {
        super(service);
        this.doctorsService = doctorsService;
    }

    @GetMapping("/doctor/{doctorId}")
    public List<MedicalService> getByDoctorId(@PathVariable int doctorId) {
        Doctor doctor = doctorsService.getById(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        return ((MedicalServiceService) service).getByDoctor(doctor);
    }
}
