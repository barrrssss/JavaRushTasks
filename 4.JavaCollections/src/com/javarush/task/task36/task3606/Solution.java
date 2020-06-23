package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
//        File file = new File(packageName);
//        File[] files = file.listFiles((dir, name) -> {
//            if (name.endsWith(".class")) return true;
//
//            return false;
//        });
//
//        MyClassLoader myClassLoader = new MyClassLoader()

        List<Class> classes = null;
        try {
            classes = Files.walk(Paths.get(packageName))
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
                            if (aClass.getDeclaredConstructor() != null && Arrays.asList(aClass.getInterfaces()).contains(HiddenClass.class)) return true;
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        hiddenClasses.addAll(classes);
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        HiddenClass hiddenClass = null;

        for (Class clazz : hiddenClasses){
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())){

                try {
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);


                    hiddenClass = (HiddenClass) constructor.newInstance();
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return hiddenClass;
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

