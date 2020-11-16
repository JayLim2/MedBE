package ru.sergei.komarov.med.controller.data.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.DoctorSpecialization;
import ru.sergei.komarov.med.service.DoctorSpecializationService;
import ru.sergei.komarov.med.service.user.DoctorService;
import ru.sergei.komarov.med.util.Utils;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController extends BasicUserController<Doctor> {
    private final DoctorSpecializationService doctorSpecializationService;

    public DoctorController(DoctorService service, DoctorSpecializationService doctorSpecializationService) {
        super(service);
        this.doctorSpecializationService = doctorSpecializationService;
    }

    @Override
    public Doctor getById(@PathVariable Integer id) {
        Doctor doctor = super.getById(id);
        Utils.requireNonNull(doctor);
        return doctor;
    }

    @GetMapping("/get/spec/{specializationName}")
    public List<Doctor> getBySpecialization(@PathVariable String specializationName) {
        DoctorSpecialization specialization = doctorSpecializationService.getByName(specializationName);
        Utils.requireNonNull(specialization);
        return ((DoctorService) service).getBySpecialization(specialization);
    }
}
