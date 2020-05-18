package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1) + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws IOException {
        File directory = new File(pathToAnimals);

//        File[] files = directory.listFiles(file -> file.isFile() && file.getName().endsWith(".java"));
//        Objects.requireNonNull(files);
//        Class[] classes = new Class[files.length];
//
//        try {
//            for (int i = 0; i < files.length; i++){
//                URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{directory.toURI().toURL()});
//                classes[i] = urlClassLoader.loadClass(files[i].getName());
//            }
//        } catch (MalformedURLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        System.out.println(pathToAnimals);
        Path pdirectory = Paths.get(pathToAnimals);

        Set<Animal> set = Files.walk(pdirectory)
                .filter(path -> path.getFileName().toString().endsWith(".class"))
                .map(path -> {
                    Class clazz = null;
                    try {
                        MyClassLoader myClassLoader = new MyClassLoader(path);

                        clazz = myClassLoader.findClass(null);

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    return clazz;
                })
                .filter(aClass -> {
                    try {
                        if (aClass.getDeclaredConstructor() != null && Modifier.isPublic(aClass.getDeclaredConstructor().getModifiers()) &&
                        Arrays.asList(aClass.getInterfaces()).contains(Animal.class)) return true;
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .map(aClass -> {
                    Animal animal = null;
                    try {
                        animal = (Animal) aClass.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    return animal;
                })
                .collect(Collectors.toSet());

        return set;
    }

    public static class MyClassLoader extends ClassLoader{
        Path path;

        public MyClassLoader(Path path) {
            this.path = path;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            byte[] bytes = new byte[0];

            try {
                bytes = Files.readAllBytes(path);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return defineClass(null, bytes, 0, bytes.length);

        }
    }
}
