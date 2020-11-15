package ru.sergei.komarov.med.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.med.service.BasicDataService;

import java.util.List;

@AllArgsConstructor
public abstract class BasicDataController<T, ID> implements DataController<T, ID> {

    protected final BasicDataService<T, ID> service;

    @Override
    @GetMapping("/get/{id}")
    public T getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @Override
    @GetMapping("/get/all")
    public List<T> getAll() {
        return service.getAll();
    }

    @Override
    @PutMapping("/put")
    public T save(@RequestBody T object) {
        return service.save(object);
    }

    @Override
    @PutMapping("/put/list")
    public List<T> saveList(@RequestBody List<T> list) {
        return service.saveList(list);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable ID id) {
        service.deleteById(id);
    }

    @Override
    @DeleteMapping("/delete/all")
    public void deleteAll() {
        service.deleteAll();
    }
}
