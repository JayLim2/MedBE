package ru.sergei.komarov.med.controller.data;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.model.*;
import ru.sergei.komarov.med.service.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final MedicalServiceService medicalServiceService;
    private final DoctorCabinetService doctorCabinetService;
    private final DoctorSpecializationService doctorSpecializationService;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final UserService userService;
    private final RoleService roleService;

    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/get/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/get/{id}")
    public User getById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PutMapping("/save/patient")
    public void savePatient(String roleName,
                            String phone, String password, String passwordRepeat,
                            String email, String firstName, String middleName, String lastName,
                            String registrationAddress, String insurancePolicyNumber) {
        User user = getUser(phone, email, password, passwordRepeat, firstName, middleName, lastName, roleName);

        Patient patient = new Patient();
        //FIXME 
        //patient.setUser(user);
        patient.setRegistrationAddress(registrationAddress);
        patient.setInsurancePolicyNumber(insurancePolicyNumber);
        patientService.save(patient);

        userService.save(user);
    }

    @PutMapping("/save/doctor")
    public void saveDoctor(String roleName,
                           String phone, String password, String passwordRepeat,
                           String email, String firstName, String middleName, String lastName,
                           String cabinet, String specialization, List<String> medicalServices) {
        User user = getUser(phone, email, password, passwordRepeat, firstName, middleName, lastName, roleName);

        //FIXME
        Doctor doctor = new Doctor();
        //doctor.setUser(user);
        DoctorCabinet doctorCabinet = doctorCabinetService.getById(cabinet);
        if (doctorCabinet == null) {
            doctorCabinet = new DoctorCabinet();
            doctorCabinet.setName(cabinet);
            doctorCabinet.setRecommendedDoctorsCount(2);
            doctorCabinet.setSpecialization(specialization);
        }
        doctor.setCabinet(doctorCabinet);
        DoctorSpecialization doctorSpecialization = doctorSpecializationService.getById(specialization);
        if (doctorSpecialization == null) {
            doctorSpecialization = new DoctorSpecialization();
            doctorSpecialization.setName(specialization);
        }
        doctor.setSpecialization(doctorSpecialization);
        List<MedicalService> medicalServicesList = medicalServiceService.getByNameIn(medicalServices);
        doctor.setMedicalServices(medicalServicesList);
        doctor.setWorkingNow(true);
        doctor.setPatientTickets(null);
        doctorService.save(doctor);
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

        Role role = roleService.getById(roleName);
        user.setRole(role);

        return user;
    }

}
