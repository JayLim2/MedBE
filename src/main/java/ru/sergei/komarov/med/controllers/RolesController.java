package ru.sergei.komarov.med.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.models.Role;
import ru.sergei.komarov.med.services.RolesService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RolesController implements BasicDataController<Role, String> {
    
    private final RolesService rolesService;

    @GetMapping("/get")
    public JsonObject getById(String name) {
        Role role = rolesService.getById(name);
        return null;
    }

    @GetMapping("/get/all")
    public JsonArray getAll() {
        List<Role> roles = rolesService.getAll();
        return null;
    }

    @PutMapping("/save")
    public JsonElement save(JsonObject jsonObject) {
        return null;
    }

    @PutMapping("/save/list")
    public JsonElement saveList(JsonArray jsonArray) {
        return null;
    }

    @DeleteMapping("/delete")
    public JsonElement deleteById(String name) {
        rolesService.deleteById(name);
        return null;
    }

    @DeleteMapping("/delete/all")
    public JsonElement deleteAll() {
        rolesService.deleteAll();
        return null;
    }
}
