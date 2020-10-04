package ru.sergei.komarov.med.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergei.komarov.med.models.*;
import ru.sergei.komarov.med.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final MedicalServicesService medicalServicesService;
    private final DoctorCabinetsService doctorCabinetsService;
    private final DoctorSpecializationsService doctorSpecializationsService;
    private final DoctorsService doctorsService;
    private final PatientsService patientsService;
    private final UsersService usersService;
    private final RolesService rolesService;

    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/get/all")
    public List<User> getAll() {
        return usersService.getAll();
    }

    @PutMapping("/save/patient")
    public void savePatient(String roleName,
                            String phone, String password, String passwordRepeat,
                            String email, String firstName, String middleName, String lastName,
                            String registrationAddress, String insurancePolicyNumber) {

        User user = getUser(phone, email, password, passwordRepeat, firstName, middleName, lastName, roleName);

        Patient patient = new Patient();
        patient.setUser(user);
        patient.setRegistrationAddress(registrationAddress);
        patient.setInsurancePolicyNumber(insurancePolicyNumber);
        patientsService.save(patient);

        usersService.save(user);
    }

    @PutMapping("/save/doctor")
    public void saveDoctor(String roleName,
                           String phone, String password, String passwordRepeat,
                           String email, String firstName, String middleName, String lastName,
                           String cabinet, String specialization, List<String> medicalServices) {

        User user = getUser(phone, email, password, passwordRepeat, firstName, middleName, lastName, roleName);

        Doctor doctor = new Doctor();
        doctor.setUser(user);
        DoctorCabinet doctorCabinet = doctorCabinetsService.getById(cabinet);
        if(doctorCabinet == null) {
            doctorCabinet = new DoctorCabinet();
            doctorCabinet.setName(cabinet);
            doctorCabinet.setRecommendedDoctorsCount(2);
            doctorCabinet.setSpecialization(specialization);
        }
        doctor.setCabinet(doctorCabinet);
        DoctorSpecialization doctorSpecialization = doctorSpecializationsService.getById(specialization);
        if(doctorSpecialization == null) {
            doctorSpecialization = new DoctorSpecialization();
            doctorSpecialization.setName(specialization);
        }
        doctor.setSpecialization(doctorSpecialization);
        List<MedicalService> medicalServicesList = medicalServicesService.getByNameIn(medicalServices);
        doctor.setMedicalServices(medicalServicesList);
        doctor.setWorkingNow(true);
        doctor.setPatientTickets(null);
        doctorsService.save(doctor);
    }

    @PutMapping("/save/admin")
    public void saveAdmin() {

    }


    private User getUser(String phone, String email, String password, String passwordRepeat,
                          String firstName, String middleName, String lastName,
                          String roleName) {

        User user = new User();
        user.setPhone(phone);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        if (!Objects.equals(password, passwordRepeat)) {
            throw new IllegalArgumentException();
        }
        user.setPassword(passwordEncoder.encode(password));

        Role role = rolesService.getById(roleName);
        user.setRole(role);

        return user;
    }

}
