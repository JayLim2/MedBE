package ru.sergei.komarov.med.controller.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.MedicalService;
import ru.sergei.komarov.med.service.MedicalServiceService;
import ru.sergei.komarov.med.service.user.DoctorService;
import ru.sergei.komarov.med.util.Utils;

import java.util.List;

@RestController
@RequestMapping("/api/medicalServices")
public class MedicalServiceController extends BasicDataController<MedicalService, String> {
    private final DoctorService doctorsService;

    public MedicalServiceController(MedicalServiceService service, DoctorService doctorsService) {
        super(service);
        this.doctorsService = doctorsService;
    }

    @GetMapping("/doctor/{doctorId}")
    public List<MedicalService> getByDoctorId(@PathVariable Integer doctorId) {
        Doctor doctor = doctorsService.getById(doctorId);
        Utils.requireNonNull(doctor);
        return ((MedicalServiceService) service).getByDoctor(doctor);
    }
}
