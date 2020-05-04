package com.javarush.task.task20.task2016;

import java.io.*;

/*
Минимум изменений
*/
public class Solution implements Serializable {

    public Solution(){};

    public class A implements Serializable {
        String name = "A";

        public A(){};

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(){};

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(){};

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution.C c = new Solution().new C("C object");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream.writeObject(c);

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Solution.C c1 = (Solution.C) objectInputStream.readObject();






    }
}
