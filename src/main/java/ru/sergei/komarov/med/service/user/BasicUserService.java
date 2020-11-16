package ru.sergei.komarov.med.service.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.sergei.komarov.med.model.User;
import ru.sergei.komarov.med.repository.UserRepository;
import ru.sergei.komarov.med.service.BasicDataService;

public abstract class BasicUserService<T extends User> extends BasicDataService<T, Integer> implements UserDetailsService {

    public BasicUserService(CrudRepository<T, Integer> repository) {
        super(repository);
    }

    public User getByLogin(String login) {
        return ((UserRepository<T>) repository).findByPhoneOrEmail(login, login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return getByLogin(login);
    }
}
