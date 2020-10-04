package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.Role;
import ru.sergei.komarov.med.repositories.RolesRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RolesService implements BasicDataService<Role, String> {

    private final RolesRepository rolesRepository;

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
    public void saveList(List<Role> items) {
        rolesRepository.saveAll(items);
    }

    @Override
    public void deleteById(String s) {
        rolesRepository.deleteById(s);
    }

    @Override
    public void delete(Role item) {
        rolesRepository.delete(item);
    }

    @Override
    public void deleteAll() {
        rolesRepository.deleteAll();
    }
}
