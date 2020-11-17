package ru.sergei.komarov.med.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.model.*;
import ru.sergei.komarov.med.service.DoctorCabinetService;
import ru.sergei.komarov.med.service.DoctorSpecializationService;
import ru.sergei.komarov.med.service.user.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/init")
public class InitController {

    private final DoctorSpecializationService doctorSpecializationService;
    private final DoctorCabinetService doctorCabinetService;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public InitController(DoctorSpecializationService doctorSpecializationService,
                          DoctorCabinetService doctorCabinetService,
                          UserService userService,
                          BCryptPasswordEncoder passwordEncoder) {
        this.doctorSpecializationService = doctorSpecializationService;
        this.doctorCabinetService = doctorCabinetService;

        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/all")
    public void initialize() {
        initUsers();
    }

    public String getRandomString(List<String> strings) {
        Random random = new Random();
        int size = strings.size();
        if (size == 1) {
            return strings.get(0);
        } else {
            String value = strings.get(random.nextInt(size));
            strings.remove(value);
            return value;
        }
    }

    private long phone = 7_900_100_00_00L;

    public String getPhone() {
        return Long.toString(phone++);
    }

    @GetMapping("/users")
    public void initUsers() {
        List<User> users = new ArrayList<>();
        List<DoctorSpecialization> specializations = new ArrayList<>();
        List<DoctorCabinet> cabinets = new ArrayList<>();

        List<String> specs = new ArrayList<>(Arrays.asList(
                "Врач общей практики", "Терапевт", "Кардиолог",
                "Эндокринолог", "Стоматолог", "Диагност"
        ));

        List<String> firstNames = new ArrayList<>(Arrays.asList(
                "Иван", "Игорь", "Михаил", "Виктор", "Сергей",
                "Ярополк", "Евпатий", "Никита"
        ));
        List<String> lastNames = new ArrayList<>(Arrays.asList(
                "Иванов", "Петров", "Кузнецов", "Баранов", "Синицын"
        ));
        List<String> middleNames = new ArrayList<>(Arrays.asList(
                "Иванович", "Игоревич", "Михайлович", "Викторович",
                "Сергеевич", "Ярополкович", "Евпатиевич", "Никитич"
        ));

        for (int i = 1; i <= 5; i++) {
            Patient patient = new Patient();
            patient.setPhone(getPhone());
            patient.setPassword(passwordEncoder.encode("root"));
            patient.setFirstName(getRandomString(firstNames));
            patient.setLastName(getRandomString(lastNames));
            patient.setMiddleName(getRandomString(middleNames));
            patient.setRole(Role.PATIENT);
            patient.setRegistrationAddress("Адрес " + i);
            patient.setBirthday(LocalDate.now());
            patient.setInsurancePolicyNumber("ОМС " + i);
            users.add(patient);
        }

        for (int i = 1; i <= 3; i++) {
            DoctorSpecialization specialization = new DoctorSpecialization();
            specialization.setName(getRandomString(specs));
            specializations.add(specialization);

            DoctorCabinet cabinet = new DoctorCabinet();
            cabinet.setName(Integer.toString(i));
            cabinet.setRecommendedDoctorsCount(i);
            cabinets.add(cabinet);

            Doctor doctor = new Doctor();
            doctor.setPhone(getPhone());
            doctor.setPassword(passwordEncoder.encode("root"));
            doctor.setFirstName(getRandomString(firstNames));
            doctor.setLastName(getRandomString(lastNames));
            doctor.setMiddleName(getRandomString(middleNames));
            doctor.setRole(Role.DOCTOR);
            doctor.setWorkingNow(i % 2 == 1);
            doctor.setSpecialization(specialization);
            doctor.setCabinet(cabinet);
            users.add(doctor);
        }

        for (int i = 1; i <= 1; i++) {
            User user = new User();
            user.setPhone(getPhone());
            user.setPassword(passwordEncoder.encode("root"));
            user.setFirstName(getRandomString(firstNames));
            user.setLastName(getRandomString(lastNames));
            user.setMiddleName(getRandomString(middleNames));
            user.setRole(Role.ADMIN);
            users.add(user);
        }
        doctorCabinetService.saveList(cabinets);
        doctorSpecializationService.saveList(specializations);
        userService.saveList(users);
    }
}
