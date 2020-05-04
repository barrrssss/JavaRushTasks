package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<>("");
    }

    public String getParent(String name){
        Entry<String> current = findEntry(name);

        if (current == null) return null;

        return current.parent.elementName;
    }

    private Entry<String> findEntry(String name){
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        Entry<String> result = null;

        while (!queue.isEmpty()){
            Entry<String> entry = queue.poll();
            if (entry.elementName.equals(name)) result = entry;

            if (entry.leftChild != null){
                queue.offer(entry.leftChild);
            }

            if (entry.rightChild != null){
                queue.offer(entry.rightChild);
            }
        }

        return result;
    }

    @Override
    public int size() {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        int size = -1;

        while (!queue.isEmpty()){
            Entry<String> entry = queue.poll();
            size++;

            if (entry.leftChild != null){
                queue.offer(entry.leftChild);
            }

            if (entry.rightChild != null){
                queue.offer(entry.rightChild);
            }
        }

        return size;
    }

//    @Override
//    public boolean add(String s) {
//        Queue<Entry<String>> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()){
//            Entry<String> entry = queue.poll();
//
//            if (entry.availableToAddLeftChildren) {
//                entry.leftChild = new Entry<>(s, entry);
//                entry.availableToAddLeftChildren = false;
//                return true;
//            }
//            if (entry.leftChild != null){
//                queue.offer(entry.leftChild);
//            }
//
//            if (entry.availableToAddRightChildren) {
//                entry.rightChild = new Entry<>(s, entry);
//                entry.availableToAddRightChildren = false;
//                return true;
//            }
//            if (entry.rightChild != null){
//                queue.offer(entry.rightChild);
//            }
//        }
//
//        return false;
//    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        List<Entry<String>> elementsWhithoutChilds = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Entry<String> entry = queue.poll();

            if (entry.availableToAddLeftChildren) {
                entry.leftChild = new Entry<>(s, entry);
                entry.availableToAddLeftChildren = false;
                return true;
            }
            if (entry.leftChild != null){
                queue.offer(entry.leftChild);
            }

            if (entry.availableToAddRightChildren) {
                entry.rightChild = new Entry<>(s, entry);
                entry.availableToAddRightChildren = false;
                return true;
            }
            if (entry.rightChild != null){
                queue.offer(entry.rightChild);
            }

            if (!entry.isAvailableToAddChildren() && entry.rightChild == null && entry.leftChild == null){
                elementsWhithoutChilds.add(entry);
            }
        }

        if (elementsWhithoutChilds.isEmpty()) return false;

        for (Entry<String> entry : elementsWhithoutChilds){
            entry.availableToAddRightChildren = true;
            entry.availableToAddLeftChildren = true;
        }

        return add(s);
    }

    @Override
    public boolean remove(Object name){
        if (!(name instanceof String)) throw new UnsupportedOperationException("name must be only String");

        Entry<String> current = findEntry((String) name);
        Entry<String> parrent = current.parent;

        if (parrent.leftChild == current) {
            parrent.leftChild = null;
            return true;
        }
        if (parrent.rightChild == current) {
            parrent.rightChild = null;
            return true;
        }
        return false;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    public

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public Entry(String elementName, Entry<T> parent){
            this(elementName);
            this.parent = parent;
        }

        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
