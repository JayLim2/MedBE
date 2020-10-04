package ru.sergei.komarov.med.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.exceptions.DoctorNotFoundException;
import ru.sergei.komarov.med.exceptions.SpecializationNotFoundException;
import ru.sergei.komarov.med.exceptions.UserNotFoundException;
import ru.sergei.komarov.med.models.Doctor;
import ru.sergei.komarov.med.models.DoctorSpecialization;
import ru.sergei.komarov.med.models.User;
import ru.sergei.komarov.med.services.DoctorSpecializationsService;
import ru.sergei.komarov.med.services.DoctorsService;
import ru.sergei.komarov.med.services.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@AllArgsConstructor
public class DoctorsController implements BasicDataController<Doctor, Integer> {

    private final UsersService usersService;
    private final DoctorsService doctorsService;
    private final DoctorSpecializationsService doctorSpecializationsService;

    @GetMapping("/get/{doctorId}")
    public JsonObject getById(@PathVariable Integer doctorId) {
        Doctor doctor = doctorsService.getById(doctorId);
        if (doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        return new JsonObject();
    }

    @GetMapping("/get/all")
    public JsonArray getAll() {
        List<Doctor> doctors = doctorsService.getAll();
        return new JsonArray();
    }

    @GetMapping("/get/user")
    public JsonObject getByUser(String phone) {
        User user = usersService.getById(phone);
        if (user == null) {
            throw new UserNotFoundException(phone);
        }
        Doctor doctor = doctorsService.getByUser(user);
        return new JsonObject();
    }

    @GetMapping("/get/spec/{specializationName}")
    public JsonArray getBySpecialization(@PathVariable String specializationName) {
        DoctorSpecialization specialization = doctorSpecializationsService.getById(specializationName);
        if (specialization == null) {
             throw new SpecializationNotFoundException(specializationName);
        }
        List<Doctor> doctors = doctorsService.getBySpecialization(specialization);
        return new JsonArray();
    }

    @PutMapping("/save")
    public JsonElement save(@RequestBody JsonObject jsonDoctor) {
        return new JsonPrimitive("Saved successfully.");
    }

    @PutMapping("/save/list")
    public JsonElement saveList(@RequestBody JsonArray jsonDoctors) {
        return new JsonPrimitive("List has been saved successfully.");
    }

    @DeleteMapping("/delete/{doctorId}")
    public JsonElement deleteById(@PathVariable Integer doctorId) {
        doctorsService.deleteById(doctorId);
        return new JsonPrimitive("Deleted by id successfully.");
    }

    @DeleteMapping("/delete/all")
    public JsonElement deleteAll() {
        doctorsService.deleteAll();
        return new JsonPrimitive("Deleted successfully.");
    }

}
