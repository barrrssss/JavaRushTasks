package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Set<String> set = new AmigoSet<>();
        set.add("Hello");
        set.add("my");
        set.add("name");
        set.add("is");
        set.add("Vadik");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream.writeObject(set);

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Set<String> set1 = (Set<String>) objectInputStream.readObject();

        System.out.println(set);
        System.out.println(set1);

    }

    private static final transient Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> c) {
        this.map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
        addAll(c);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();

        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");

        objectOutputStream.writeInt(capacity);
        objectOutputStream.writeFloat(loadFactor);
        objectOutputStream.writeInt(map.size());

        for (E e : map.keySet()){
            objectOutputStream.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();

        int capacity = objectInputStream.readInt();
        float loadFactor = objectInputStream.readFloat();
        int size = objectInputStream.readInt();

        map = new HashMap<>(capacity, loadFactor);

        for (int i = 0; i < size; i++){
            E e = (E) objectInputStream.readObject();
            map.put(e, PRESENT);
        }
    }

    @Override
    public AmigoSet<E> clone() {
        AmigoSet<E> newAmigoSet;

        try {
            newAmigoSet = (AmigoSet) super.clone();
            newAmigoSet.map = (HashMap<E, Object>) map.clone();
        } catch (Exception e){
            throw new InternalError();
        }

        return newAmigoSet;
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }

    @Override
    public void clear() {
        map.clear();
    }
}
