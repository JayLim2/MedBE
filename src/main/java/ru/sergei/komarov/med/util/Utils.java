package ru.sergei.komarov.med.util;

import ru.sergei.komarov.med.exception.BasicNotFoundException;

public class Utils {
    public static <T> T requireNonNull(T object) {
        if (object == null)
            throw new BasicNotFoundException();
        return object;
    }
}
