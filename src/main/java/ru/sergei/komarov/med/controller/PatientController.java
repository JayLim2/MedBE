package ru.sergei.komarov.med.controller;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sergei.komarov.med.exception.UserNotFoundException;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.model.User;
import ru.sergei.komarov.med.service.PatientService;
import ru.sergei.komarov.med.service.UserService;

@Controller
public class PatientController extends BasicDataController<Patient, Integer> {
    private final UserService userService;

    public PatientController(PatientService service, UserService userService) {
        super(service);
        this.userService = userService;
    }

    @GetMapping("/get/user")
    public JsonObject getByUser(String phone) {
        User user = userService.getById(phone);
        if (user == null) {
            throw new UserNotFoundException(phone);
        }
        Patient patient = ((PatientService) service).getByUser(user);
        return new JsonObject();
    }
}
