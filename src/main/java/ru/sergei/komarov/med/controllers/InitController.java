package ru.sergei.komarov.med.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.models.Role;
import ru.sergei.komarov.med.models.User;
import ru.sergei.komarov.med.services.RolesService;
import ru.sergei.komarov.med.services.UsersService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/init")
public class InitController {

    private UsersService usersService;
    private RolesService rolesService;
    private BCryptPasswordEncoder passwordEncoder;

    public InitController(UsersService usersService,
                          RolesService rolesService,
                          BCryptPasswordEncoder passwordEncoder) {

        this.usersService = usersService;
        this.rolesService = rolesService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/all")
    public void initialize() {
        initRoles();
        initUsers();
    }

    @GetMapping("/roles")
    public void initRoles() {
        Arrays.asList("ROLE_USER", "ROLE_SUPPORT", "ROLE_ADMIN")
                .forEach(roleName -> {
                    Role role = new Role();
                    role.setName(roleName);
                    rolesService.save(role);
                });
    }

    @GetMapping("/users")
    public void initUsers() {
        List<User> users = new ArrayList<>();

        Role userRole = rolesService.getById("ROLE_USER");
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("ROLE_USER");
        }

        Role supportEmployeeRole = rolesService.getById("ROLE_SUPPORT");
        if (supportEmployeeRole == null) {
            supportEmployeeRole = new Role();
            supportEmployeeRole.setName("ROLE_SUPPORT");
        }

        Role adminRole = rolesService.getById("ROLE_ADMIN");
        if (adminRole == null) {
            adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
        }

        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setUsername("user" + i);
            user.setPassword(passwordEncoder.encode("root"));
            user.setFullName("User Userovich " + i);
            user.setRole(userRole);
            users.add(user);
        }

        for (int i = 1; i <= 3; i++) {
            User user = new User();
            user.setUsername("support" + i);
            user.setPassword(passwordEncoder.encode("root"));
            user.setFullName("Support Userovich " + i);
            user.setRole(supportEmployeeRole);
            users.add(user);
        }

        for (int i = 1; i <= 1; i++) {
            User user = new User();
            user.setUsername("admin" + i);
            user.setPassword(passwordEncoder.encode("root"));
            user.setFullName("Admin Userovich " + i);
            user.setRole(adminRole);
            users.add(user);
        }

        usersService.saveAll(users);
    }
}
