package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here

        V value = cache.get(key);

        if (value == null){
            Class[] params = {key.getClass()};
            value = clazz.getConstructor(params).newInstance(key);
            cache.put(key, value);
        }

        return value;
    }

    public boolean put(V obj) {
        //TODO add your code here

        boolean result = true;

        Class clazz = obj.getClass();
        try {
            Method method = clazz.getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            result = false;
        }

        return result;
    }

    public int size() {
        return cache.size();
    }
}
