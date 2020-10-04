package ru.sergei.komarov.med.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.exceptions.SpecializationNotFoundException;
import ru.sergei.komarov.med.models.DoctorSpecialization;
import ru.sergei.komarov.med.services.DoctorSpecializationsService;

import java.util.List;

@RestController
@RequestMapping("/api/doctorSpecializations")
@AllArgsConstructor
public class DoctorSpecializationsController implements BasicDataController<DoctorSpecialization, String> {

    private final DoctorSpecializationsService doctorSpecializationsService;

    @GetMapping("/get")
    public JsonObject getById(@RequestParam String name) {
        DoctorSpecialization specialization = doctorSpecializationsService.getById(name);
        if(specialization == null) {
            throw new SpecializationNotFoundException(name);
        }
        return new JsonObject();
    }

    @GetMapping("/get/all")
    public JsonArray getAll() {
        List<DoctorSpecialization> specializations = doctorSpecializationsService.getAll();
        return new JsonArray();
    }

    @PutMapping("/save")
    public JsonElement save(@RequestBody JsonObject jsonSpecialization) {
        return new JsonPrimitive("Saved successfully.");
    }

    @PutMapping("/save/list")
    public JsonElement saveList(@RequestBody JsonArray jsonSpecializations) {
        return new JsonPrimitive("List has been saved successfully.");
    }

    @DeleteMapping("/delete")
    public JsonElement deleteById(@RequestParam String name) {
        doctorSpecializationsService.deleteById(name);
        return new JsonPrimitive("Deleted successfully.");
    }

    @DeleteMapping("/deleteAll")
    public JsonElement deleteAll() {
        doctorSpecializationsService.deleteAll();
        return new JsonPrimitive("All items have been deleted.");
    }

}
