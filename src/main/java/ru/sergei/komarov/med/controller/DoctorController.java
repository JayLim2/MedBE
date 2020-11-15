package ru.sergei.komarov.med.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.exception.DoctorNotFoundException;
import ru.sergei.komarov.med.exception.SpecializationNotFoundException;
import ru.sergei.komarov.med.exception.UserNotFoundException;
import ru.sergei.komarov.med.model.Doctor;
import ru.sergei.komarov.med.model.DoctorSpecialization;
import ru.sergei.komarov.med.model.User;
import ru.sergei.komarov.med.service.DoctorService;
import ru.sergei.komarov.med.service.DoctorSpecializationService;
import ru.sergei.komarov.med.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController extends BasicDataController<Doctor, Integer> {
    private final UserService userService;
    private final DoctorSpecializationService doctorSpecializationService;

    public DoctorController(DoctorService service, UserService userService, DoctorSpecializationService doctorSpecializationService) {
        super(service);
        this.userService = userService;
        this.doctorSpecializationService = doctorSpecializationService;
    }

    @Override
    public Doctor getById(Integer doctorId) {
        Doctor doctor = super.getById(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        return doctor;
    }

    @GetMapping("/get/user")
    public Doctor getByUser(String phone) {
        User user = userService.getById(phone);
        if (user == null) {
            throw new UserNotFoundException(phone);
        }
        return ((DoctorService) service).getByUser(user);
    }

    @GetMapping("/get/spec/{specializationName}")
    public List<Doctor> getBySpecialization(@PathVariable String specializationName) {
        DoctorSpecialization specialization = doctorSpecializationService.getById(specializationName);
        if (specialization == null) {
            throw new SpecializationNotFoundException(specializationName);
        }
        return ((DoctorService) service).getBySpecialization(specialization);
    }
}
