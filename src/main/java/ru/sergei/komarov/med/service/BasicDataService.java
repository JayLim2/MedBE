package ru.sergei.komarov.med.service;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import ru.sergei.komarov.med.controller.DataController;

import java.util.List;

@AllArgsConstructor
public abstract class BasicDataService<T, ID> implements DataController<T, ID> {
    protected final CrudRepository<T, ID> repository;

    @Override
    public T getById(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) repository.findAll();
    }

    @Override
    public T save(T object) {
        return repository.save(object);
    }

    @Override
    public List<T> saveList(List<T> list) {
        return (List<T>) repository.saveAll(list);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
