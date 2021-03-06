package ru.sergei.komarov.med.controller.data.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.model.Patient;
import ru.sergei.komarov.med.service.user.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController extends BasicUserController<Patient> {

    public PatientController(PatientService service) {
        super(service);
    }
}
