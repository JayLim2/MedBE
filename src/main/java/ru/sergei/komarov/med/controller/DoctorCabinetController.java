package ru.sergei.komarov.med.controller;

import org.springframework.stereotype.Controller;
import ru.sergei.komarov.med.model.DoctorCabinet;
import ru.sergei.komarov.med.service.DoctorCabinetService;

@Controller
public class DoctorCabinetController extends BasicDataController<DoctorCabinet, String> {
    public DoctorCabinetController(DoctorCabinetService service) {
        super(service);
    }
}
