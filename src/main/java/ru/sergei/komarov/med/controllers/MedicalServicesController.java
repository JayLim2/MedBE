package ru.sergei.komarov.med.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.exceptions.DoctorNotFoundException;
import ru.sergei.komarov.med.models.Doctor;
import ru.sergei.komarov.med.models.MedicalService;
import ru.sergei.komarov.med.services.DoctorsService;
import ru.sergei.komarov.med.services.MedicalServicesService;

import java.util.List;

@RestController
@RequestMapping("/api/medicalServices")
@AllArgsConstructor
public class MedicalServicesController implements BasicDataController<MedicalService, String> {

    private final DoctorsService doctorsService;
    private final MedicalServicesService medicalServicesService;

    @GetMapping("/get")
    public JsonObject getById(@RequestParam String name) {
        MedicalService medicalService = medicalServicesService.getById(name);
        return new JsonObject();
    }

    @GetMapping("/get/all")
    public JsonArray getAll() {
        List<MedicalService> medicalServices = medicalServicesService.getAll();
        return new JsonArray();
    }

    @GetMapping("/doctor/{doctorId}")
    public JsonArray getByDoctorId(@PathVariable int doctorId) {
        Doctor doctor = doctorsService.getById(doctorId);
        if(doctor == null) {
            throw new DoctorNotFoundException(doctorId);
        }
        List<MedicalService> medicalServices = medicalServicesService.getByDoctor(doctor);
        return new JsonArray();
    }

    @PutMapping("/save")
    public JsonElement save(JsonObject jsonObject) {
        return new JsonPrimitive("Saved successfully.");
    }

    @PutMapping("/save/list")
    public JsonElement saveList(JsonArray jsonArray) {
        return new JsonPrimitive("List has been successfully.");
    }

    @DeleteMapping("/delete")
    public JsonElement deleteById(@RequestParam String name) {
        medicalServicesService.deleteById(name);
        return new JsonPrimitive("Deleted successfully.");
    }

    @DeleteMapping("/delete/all")
    public JsonElement deleteAll() {
        medicalServicesService.deleteAll();
        return new JsonPrimitive("All items have been deleted1 successfully.");
    }

}
