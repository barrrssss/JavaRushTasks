package com.javarush.task.task22.task2208;

import java.util.*;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map =  new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        List<String> filters = new ArrayList<>();

        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getValue() == null) {
                iterator.remove();
            }
            else {
                String filter = String.format("%s = '%s'", pair.getKey(), pair.getValue());
                filters.add(filter);
            }
        }

        String result = String.join(" and ", filters.toArray(new String[filters.size()]));

        return result;
    }
}
