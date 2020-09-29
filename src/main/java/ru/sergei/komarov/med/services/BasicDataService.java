package ru.sergei.komarov.med.services;

import java.util.List;

public interface BasicDataService<T, ID> {

    T getById(ID id);

    List<T> getAll();

    void save(T item);

    void saveAll(List<T> items);

    void delete(T item);

}
