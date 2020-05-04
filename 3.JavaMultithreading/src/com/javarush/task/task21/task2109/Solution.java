package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            B newObject = new C(getI(), getJ(), getName());
            return newObject;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        A a = new A(1, 1);
        A a1 = (A) a.clone();

        B b = new B(2, 2, "Vadik");
        try {
            B b1 = (B) b.clone();
        } catch (CloneNotSupportedException e){
            System.out.println("Exeption throws");
        }

        C c = new C(3, 3, "Dasha");
        try {
            C c1 = (C) c.clone();
        } catch (CloneNotSupportedException e){
            System.out.println("C exeption was caught");
        }

    }
}
