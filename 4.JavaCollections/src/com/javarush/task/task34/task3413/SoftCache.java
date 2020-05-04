package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.getOrDefault(key, null);

        if (softReference == null) return null;

        return softReference.get();
    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        AnyObject anyObject = null;

        if (softReference != null){
            anyObject = softReference.get();
            softReference.clear();
        }

        return anyObject;
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        AnyObject anyObject = null;

        if (softReference != null){
            anyObject = softReference.get();
            softReference.clear();
        }

        return anyObject;

    }
}