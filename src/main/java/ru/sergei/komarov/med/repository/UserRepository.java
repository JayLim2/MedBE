package ru.sergei.komarov.med.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.model.User;

public interface UserRepository extends CrudRepository<User, String> {
    User findByPhone(String phone);
}
