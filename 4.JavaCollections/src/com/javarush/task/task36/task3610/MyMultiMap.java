package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (Map.Entry<K, List<V>> entry : map.entrySet()){
            size += entry.getValue().size();
        }

        return size;
    }

    @Override
    public V put(K key, V value) {
        List<V> list = map.get(key);

        if (list == null){
            list = new ArrayList<>();
            list.add(value);
            map.put(key, list);

            return null;
        } else {
            if (list.size() == repeatCount) list.remove(0);

            list.add(value);

            return list.get(list.size() - 2);
        }
    }

    @Override
    public V remove(Object key) {
        List<V> list = map.get(key);

        if (list == null) return null;

        V removable = list.remove(0);
        if (list.size() == 0) map.remove(key);

        return removable;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        List<V> list = new ArrayList<>();

        for (Map.Entry<K, List<V>> entry : map.entrySet()){
            list.addAll(entry.getValue());
        }

        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (Map.Entry<K, List<V>> entry : map.entrySet()){
            if(entry.getValue().contains(value)) return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}