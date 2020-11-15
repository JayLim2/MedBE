package ru.sergei.komarov.med.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.exception.UserNotFoundException;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.model.User;
import ru.sergei.komarov.med.service.PatientService;
import ru.sergei.komarov.med.service.UserService;

@RestController
@RequestMapping("/api/patients")
public class PatientController extends BasicDataController<Patient, Integer> {
    private final UserService userService;

    public PatientController(PatientService service, UserService userService) {
        super(service);
        this.userService = userService;
    }

    @GetMapping("/get/user")
    public Patient getByUser(String phone) {
        User user = userService.getById(phone);
        if (user == null) {
            throw new UserNotFoundException(phone);
        }
        return ((PatientService) service).getByUser(user);
    }
}
