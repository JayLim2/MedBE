package ru.sergei.komarov.med.controller;

import org.springframework.stereotype.Controller;
import ru.sergei.komarov.med.model.Role;
import ru.sergei.komarov.med.service.RoleService;

@Controller
public class RoleController extends BasicDataController<Role, String> {
    public RoleController(RoleService service) {
        super(service);
    }
}
