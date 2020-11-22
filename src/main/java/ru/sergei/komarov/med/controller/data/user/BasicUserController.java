package ru.sergei.komarov.med.controller.data.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import ru.sergei.komarov.med.controller.data.BasicDataController;
import ru.sergei.komarov.med.model.User;
import ru.sergei.komarov.med.service.BasicDataService;
import ru.sergei.komarov.med.service.user.BasicUserService;

public abstract class BasicUserController<T extends User> extends BasicDataController<T, Integer> {
    public BasicUserController(BasicDataService<T, Integer> service) {
        super(service);
    }

    @GetMapping("/get/login/{login}")
    public User getByLogin(@PathVariable String login) {
        return ((BasicUserService<?>) service).getByLogin(login);
    }

    @PutMapping("/register")
    public T register(@RequestBody T newUser) {
        if (getByLogin(newUser.getPhone()) != null || (newUser.getEmail() != null && getByLogin(newUser.getEmail()) != null)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return service.save(newUser);
    }
}