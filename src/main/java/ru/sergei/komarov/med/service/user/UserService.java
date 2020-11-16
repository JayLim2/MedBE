package ru.sergei.komarov.med.service.user;

import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.User;
import ru.sergei.komarov.med.repository.UserRepository;

@Service
public class UserService extends BasicUserService<User> {
    public UserService(UserRepository<User> repository) {
        super(repository);
    }
}
