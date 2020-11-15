package ru.sergei.komarov.med.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.model.Role;
import ru.sergei.komarov.med.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController extends BasicDataController<Role, String> {
    public RoleController(RoleService service) {
        super(service);
    }
}
