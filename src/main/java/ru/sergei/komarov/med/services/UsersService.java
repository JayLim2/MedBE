package ru.sergei.komarov.med.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.med.models.User;
import ru.sergei.komarov.med.repositories.UsersRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService, BasicDataService<User, String> {

    private final UsersRepository usersRepository;

    @Override
    public User getById(String username) {
        return usersRepository.findById(username).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) usersRepository.findAll();
    }

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public void saveList(List<User> users) {
        usersRepository.saveAll(users);
    }

    @Override
    public void deleteById(String s) {
        usersRepository.deleteById(s);
    }

    @Override
    public void delete(User item) {
        usersRepository.delete(item);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return getById(login);
    }

    @Override
    public void deleteAll() {
        usersRepository.deleteAll();
    }
}
