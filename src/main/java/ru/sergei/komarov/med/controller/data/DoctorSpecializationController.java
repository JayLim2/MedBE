package ru.sergei.komarov.med.controller.data;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.model.DoctorSpecialization;
import ru.sergei.komarov.med.service.DoctorSpecializationService;
import ru.sergei.komarov.med.util.Utils;

import java.util.Set;

@RestController
@RequestMapping("/api/doctorSpecializations")
public class DoctorSpecializationController extends BasicDataController<DoctorSpecialization, Integer> {
    public DoctorSpecializationController(DoctorSpecializationService service) {
        super(service);
    }

    @Override
    public DoctorSpecialization getById(@PathVariable Integer id) {
        DoctorSpecialization specialization = service.getById(id);
        Utils.requireNonNull(specialization);
        return specialization;
    }

    @RequestMapping("/get/allAvailable")
    public Set<DoctorSpecialization> getAllAvailable() {
        return ((DoctorSpecializationService) service).getAllAvailable();
    }
}
