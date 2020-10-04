package ru.sergei.komarov.med.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class JsonConverter {

    public static final Gson GSON;

    static {
        GSON = new GsonBuilder().setPrettyPrinting().create();
    }

    public static <T> JsonObject objectToJson(T object) {
        return null;
    }

    public static <T> T jsonToObject(JsonObject json) {
        return null;
    }

    public static <T> JsonArray listToJsonArray(List<T> list) {
        return null;
    }

    public static <T> List<T> jsonArrayToList(JsonArray jsonArray) {
        return null;
    }

}
