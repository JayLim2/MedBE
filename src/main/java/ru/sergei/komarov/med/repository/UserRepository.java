package ru.sergei.komarov.med.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sergei.komarov.med.model.User;

@Repository
public interface UserRepository<T extends User> extends CrudRepository<T, Integer> {

    T findByPhoneOrEmail(String phone, String email);
}
