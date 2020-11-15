package ru.sergei.komarov.med.service;

import java.util.List;

public interface DataService<T, ID> {

    T getById(ID id);

    List<T> getAll();

    T save(T item);

    Iterable<T> saveList(List<T> items);

    void deleteById(ID id);

    void delete(T item);

    void deleteAll();

}
