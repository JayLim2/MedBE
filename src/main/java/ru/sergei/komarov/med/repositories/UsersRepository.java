package ru.sergei.komarov.med.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.models.User;

public interface UsersRepository extends CrudRepository<User, String> {
}
