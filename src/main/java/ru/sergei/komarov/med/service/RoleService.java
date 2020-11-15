package ru.sergei.komarov.med.service;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.Role;
import ru.sergei.komarov.med.repository.RoleRepository;

@Service
public class RoleService extends BasicDataService<Role, String> {
    public RoleService(RoleRepository repository) {
        super(repository);
    }
}
