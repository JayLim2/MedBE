package ru.sergei.komarov.med.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.models.DoctorCabinet;
import ru.sergei.komarov.med.services.DoctorCabinetsService;

import java.util.List;

@RestController
@RequestMapping("/api/doctorCabinets")
@AllArgsConstructor
public class DoctorCabinetsController implements BasicDataController<DoctorCabinet, String> {

    private final DoctorCabinetsService doctorCabinetsService;

    @GetMapping("/get")
    public JsonObject getById(String s) {
        DoctorCabinet doctorCabinet = doctorCabinetsService.getById(s);
        return new JsonObject();
    }

    @GetMapping("/get/all")
    public JsonArray getAll() {
        List<DoctorCabinet> doctorCabinets = doctorCabinetsService.getAll();
        return new JsonArray();
    }

    @PutMapping("/save")
    public JsonElement save(JsonObject jsonObject) {
        return new JsonPrimitive("");
    }

    @PutMapping("/save/list")
    public JsonElement saveList(JsonArray jsonArray) {
        return new JsonPrimitive("");
    }

    @DeleteMapping("/delete")
    public JsonElement deleteById(String s) {
        doctorCabinetsService.deleteById(s);
        return new JsonPrimitive("");
    }

    @DeleteMapping("/delete/all")
    public JsonElement deleteAll() {
        doctorCabinetsService.deleteAll();
        return new JsonPrimitive("");
    }
}
