package ru.sergei.komarov.med.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.model.User;
import ru.sergei.komarov.med.repository.UserRepository;

@Service
public class UserService extends BasicDataService<User, String> implements UserDetailsService {
    public UserService(UserRepository repository) {
        super(repository);
    }

    public User getByPhone(String phone) {
        return ((UserRepository) repository).findByPhone(phone);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return getByPhone(login);
    }
}
