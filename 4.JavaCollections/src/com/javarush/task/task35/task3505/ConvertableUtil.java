package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <Key> Map convert(List<? extends Convertable<Key>> list) {
        Map result = new HashMap();

        for (Convertable convertable : list){
            result.put(convertable.getKey(), convertable);
        }

        return result;
    }
}
