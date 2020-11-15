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

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return ((UserRepository) repository).findByPhone(login);
    }
}
