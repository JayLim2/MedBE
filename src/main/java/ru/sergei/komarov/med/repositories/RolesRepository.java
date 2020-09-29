package ru.sergei.komarov.med.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.models.Role;

public interface RolesRepository extends CrudRepository<Role, String> {
}
