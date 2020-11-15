package ru.sergei.komarov.med.controller.data;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.model.DoctorCabinet;
import ru.sergei.komarov.med.service.DoctorCabinetService;

@RestController
@RequestMapping("/api/doctorCabinets")
public class DoctorCabinetController extends BasicDataController<DoctorCabinet, String> {
    public DoctorCabinetController(DoctorCabinetService service) {
        super(service);
    }
}
