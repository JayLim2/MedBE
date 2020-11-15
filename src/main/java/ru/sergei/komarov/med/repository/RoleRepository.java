package ru.sergei.komarov.med.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.model.Role;

public interface RoleRepository extends CrudRepository<Role, String> {
}
