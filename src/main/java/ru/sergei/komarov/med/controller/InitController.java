package ru.sergei.komarov.med.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.model.*;
import ru.sergei.komarov.med.service.DoctorCabinetService;
import ru.sergei.komarov.med.service.DoctorSpecializationService;
import ru.sergei.komarov.med.service.RoleService;
import ru.sergei.komarov.med.service.user.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/init")
public class InitController {

    private final DoctorSpecializationService doctorSpecializationService;
    private final DoctorCabinetService doctorCabinetService;
    private final UserService userService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    public InitController(DoctorSpecializationService doctorSpecializationService,
                          DoctorCabinetService doctorCabinetService,
                          UserService userService,
                          RoleService roleService,
                          BCryptPasswordEncoder passwordEncoder) {
        this.doctorSpecializationService = doctorSpecializationService;
        this.doctorCabinetService = doctorCabinetService;

        this.userService = userService;
        this.roleService = roleService;
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
                    roleService.save(role);
                });
    }

    @GetMapping("/users")
    public void initUsers() {
        List<User> users = new ArrayList<>();
        List<DoctorSpecialization> specializations = new ArrayList<>();
        List<DoctorCabinet> cabinets = new ArrayList<>();

        Role patientRole = roleService.getById("ROLE_PATIENT");
        if (patientRole == null) {
            patientRole = new Role();
            patientRole.setName("ROLE_PATIENT");
        }

        Role doctorRole = roleService.getById("ROLE_DOCTOR");
        if (doctorRole == null) {
            doctorRole = new Role();
            doctorRole.setName("ROLE_DOCTOR");
        }

        Role adminRole = roleService.getById("ROLE_ADMIN");
        if (adminRole == null) {
            adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
        }

        for (int i = 1; i <= 5; i++) {
            Patient patient = new Patient();
            patient.setPhone("patient" + i);
            patient.setPassword(passwordEncoder.encode("root"));
            patient.setFirstName("Пациент");
            patient.setLastName("(" + i + ") Пациентов");
            patient.setRole(patientRole);
            patient.setRegistrationAddress("Адрес " + i);
            patient.setBirthday(LocalDate.now());
            patient.setInsurancePolicyNumber("ОМС " + i);
            users.add(patient);
        }

        for (int i = 1; i <= 3; i++) {
            DoctorSpecialization specialization = new DoctorSpecialization();
            specialization.setName("Офтальпатологоанатом " + i);
            specializations.add(specialization);

            DoctorCabinet cabinet = new DoctorCabinet();
            cabinet.setName("Морг " + i);
            cabinet.setRecommendedDoctorsCount(i);
            cabinets.add(cabinet);

            Doctor doctor = new Doctor();
            doctor.setPhone("doctor" + i);
            doctor.setPassword(passwordEncoder.encode("root"));
            doctor.setFirstName("Врач");
            doctor.setLastName("(" + i + ") Лечилов");
            doctor.setRole(doctorRole);
            doctor.setWorkingNow(i % 2 == 1);
            doctor.setSpecialization(specialization);
            doctor.setCabinet(cabinet);
            users.add(doctor);
        }

        for (int i = 1; i <= 1; i++) {
            User user = new User();
            user.setPhone("admin" + i);
            user.setPassword(passwordEncoder.encode("root"));
            user.setFirstName("Админ");
            user.setLastName("(" + i + ") Админов");
            user.setRole(adminRole);
            users.add(user);
        }
        doctorCabinetService.saveList(cabinets);
        doctorSpecializationService.saveList(specializations);
        userService.saveList(users);
    }
}
