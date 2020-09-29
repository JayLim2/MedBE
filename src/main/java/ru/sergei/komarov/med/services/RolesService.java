package ru.sergei.komarov.med.services;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.Role;
import ru.sergei.komarov.med.repositories.RolesRepository;

import java.util.List;

@Service
public class RolesService implements BasicDataService<Role, String> {

    private final RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public Role getById(String name) {
        return rolesRepository.findById(name).orElse(null);
    }

    @Override
    public List<Role> getAll() {
        return (List<Role>)rolesRepository.findAll();
    }

    @Override
    public void save(Role item) {
        rolesRepository.save(item);
    }

    @Override
    public void saveAll(List<Role> items) {
        rolesRepository.saveAll(items);
    }

    @Override
    public void delete(Role item) {
        rolesRepository.delete(item);
    }
}
