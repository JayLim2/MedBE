package ru.sergei.komarov.med.controller.data;

import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.exception.SpecializationNotFoundException;
import ru.sergei.komarov.med.model.DoctorSpecialization;
import ru.sergei.komarov.med.service.DoctorSpecializationService;

@RestController
@RequestMapping("/api/doctorSpecializations")
public class DoctorSpecializationController extends BasicDataController<DoctorSpecialization, Integer> {
    public DoctorSpecializationController(DoctorSpecializationService service) {
        super(service);
    }

    @Override
    public DoctorSpecialization getById(@PathVariable Integer id) {
        DoctorSpecialization specialization = service.getById(id);
        if (specialization == null) {
            throw new SpecializationNotFoundException(Integer.toString(id));
        }
        return specialization;
    }
}
