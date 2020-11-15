package ru.sergei.komarov.med.controller.data;

import java.util.List;

public interface DataController<T, ID> {

    T getById(ID id);

    List<T> getAll();

    T save(T object);

    List<T> saveList(List<T> list);

    void deleteById(ID id);

    void deleteAll();

}
