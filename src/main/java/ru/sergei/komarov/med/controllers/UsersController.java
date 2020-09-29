package ru.sergei.komarov.med.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.models.Role;
import ru.sergei.komarov.med.models.User;
import ru.sergei.komarov.med.services.RolesService;
import ru.sergei.komarov.med.services.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;
    private final RolesService rolesService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsersController(UsersService usersService,
                           RolesService rolesService,
                           BCryptPasswordEncoder passwordEncoder) {

        this.usersService = usersService;
        this.rolesService = rolesService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/get/all")
    public List<User> getAll() {
        return usersService.getAll();
    }

    @PutMapping("/put")
    public void put(String username, String password,
                    String fullName) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setFullName(fullName);
        Role role = rolesService.getById("ROLE_USER");
        user.setRole(role);
        usersService.save(user);
    }

}
