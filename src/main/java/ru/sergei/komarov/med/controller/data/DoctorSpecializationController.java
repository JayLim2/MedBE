package ru.sergei.komarov.med.controller.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.exception.SpecializationNotFoundException;
import ru.sergei.komarov.med.model.DoctorSpecialization;
import ru.sergei.komarov.med.service.DoctorSpecializationService;

@RestController
@RequestMapping("/api/doctorSpecializations")
public class DoctorSpecializationController extends BasicDataController<DoctorSpecialization, String> {
    public DoctorSpecializationController(DoctorSpecializationService service) {
        super(service);
    }

    @GetMapping("/get")
    public DoctorSpecialization getById(@RequestParam String name) {
        DoctorSpecialization specialization = service.getById(name);
        if (specialization == null) {
            throw new SpecializationNotFoundException(name);
        }
        return specialization;
    }
}
