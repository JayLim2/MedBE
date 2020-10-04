package ru.sergei.komarov.med.services;

import java.util.List;

public interface BasicDataService<T, ID> {

    T getById(ID id);

    List<T> getAll();

    void save(T item);

    void saveList(List<T> items);

    void deleteById(ID id);

    void delete(T item);

    void deleteAll();

}
