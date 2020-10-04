package ru.sergei.komarov.med.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public interface BasicDataController<T, ID> {

    JsonObject getById(ID id);

    JsonArray getAll();

    JsonElement save(JsonObject jsonObject);

    JsonElement saveList(JsonArray jsonArray);

    JsonElement deleteById(ID id);

    JsonElement deleteAll();

}
