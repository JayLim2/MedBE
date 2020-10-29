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

@RestController
@RequestMapping("/api/init")
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
        Arrays.asList("ROLE_PATIENT", "ROLE_DOCTOR", "ROLE_ADMIN")
                .forEach(roleName -> {
                    Role role = new Role();
                    role.setName(roleName);
                    rolesService.save(role);
                });
    }

    @GetMapping("/users")
    public void initUsers() {
        List<User> users = new ArrayList<>();

        Role patientRole = rolesService.getById("ROLE_PATIENT");
        if (patientRole == null) {
            patientRole = new Role();
            patientRole.setName("ROLE_PATIENT");
        }

        Role doctorRole = rolesService.getById("ROLE_DOCTOR");
        if (doctorRole == null) {
            doctorRole = new Role();
            doctorRole.setName("ROLE_DOCTOR");
        }

        Role adminRole = rolesService.getById("ROLE_ADMIN");
        if (adminRole == null) {
            adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
        }

        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setPhone("patient" + i);
            user.setPassword(passwordEncoder.encode("root"));
            user.setFirstName("Пациент");
            user.setLastName("Пациентов");
            user.setRole(patientRole);
            users.add(user);
        }

        for (int i = 1; i <= 3; i++) {
            User user = new User();
            user.setPhone("doctor" + i);
            user.setPassword(passwordEncoder.encode("root"));
            user.setFirstName("Врач");
            user.setLastName("Лечилов");
            user.setRole(doctorRole);
            users.add(user);
        }

        for (int i = 1; i <= 1; i++) {
            User user = new User();
            user.setPhone("admin" + i);
            user.setPassword(passwordEncoder.encode("root"));
            user.setFirstName("Админ");
            user.setLastName("Админов");
            user.setRole(adminRole);
            users.add(user);
        }

        usersService.saveList(users);
    }
}
