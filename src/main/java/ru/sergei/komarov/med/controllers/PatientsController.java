package ru.sergei.komarov.med.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.exceptions.UserNotFoundException;
import ru.sergei.komarov.med.models.Doctor;
import ru.sergei.komarov.med.models.Patient;
import ru.sergei.komarov.med.models.User;
import ru.sergei.komarov.med.services.PatientsService;
import ru.sergei.komarov.med.services.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientsController implements BasicDataController<Patient, Integer> {

    private final UsersService usersService;
    private final PatientsService patientsService;

    @GetMapping("/get/{id}")
    public JsonObject getById(@PathVariable Integer id) {
        Patient patient = patientsService.getById(id);
        return null;
    }

    @GetMapping("/get/all")
    public JsonArray getAll() {
        List<Patient> patients = patientsService.getAll();
        return null;
    }

    @GetMapping("/get/user")
    public JsonObject getByUser(String phone) {
        User user = usersService.getById(phone);
        if (user == null) {
            throw new UserNotFoundException(phone);
        }
        Patient patient = patientsService.getByUser(user);
        return new JsonObject();
    }

    @PutMapping("/put")
    public JsonElement save(JsonObject jsonObject) {
        return null;
    }

    @PutMapping("/put/list")
    public JsonElement saveList(JsonArray jsonArray) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public JsonElement deleteById(@PathVariable Integer id) {
        patientsService.deleteById(id);
        return null;
    }

    @DeleteMapping("/delete/all")
    public JsonElement deleteAll() {
        patientsService.deleteAll();
        return null;
    }
}
