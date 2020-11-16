package ru.sergei.komarov.med.controller.data;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.service.BasicDataService;

import java.util.List;

@AllArgsConstructor
public abstract class BasicDataController<T, ID> {

    protected final BasicDataService<T, ID> service;

    @GetMapping("/get/{id}")
    public T getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @GetMapping("/get/all")
    public List<T> getAll() {
        return service.getAll();
    }

    @PutMapping("/save")
    public T save(@RequestBody T object) {
        return service.save(object);
    }

    @PutMapping("/save/list")
    public List<T> saveList(@RequestBody List<T> list) {
        return service.saveList(list);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable ID id) {
        service.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        service.deleteAll();
    }
}
