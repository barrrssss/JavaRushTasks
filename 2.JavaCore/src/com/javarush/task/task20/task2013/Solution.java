package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person(){};

        public String getFullName(){
            return firstName + " " + lastName;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String) (in.readObject());
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }

        public String toString(){
            String result = "Fullname = " + getFullName() +
                    "\nage = " + age ;
            result += mother != null ? "\nmother = " + mother.getFullName() : "\nno mother";
            result += father != null ? "\nfather = " + father.getFullName() : "\nno father";
            result += "\nchildren : ";
            if (children == null || children.isEmpty()) result+= "\nno children";
            else {
                for (Person child : children){
                    result += "\n" + child.getFullName();
                }
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person mother = new Person("Natalia", "Mjakisheva", 46);
        Person father = new Person("Evgeniy", "Mjakishev", 53);
        Person person = new Person("Vadik", "Mjakishev", 24);
        Person son = new Person("VadikSon", "Mjakishev", 5);
        Person daughter = new Person("VadikDaughter", "Mjakisheva", 3);
        List<Person> vadikChildren = new ArrayList();
        vadikChildren.add(son);
        vadikChildren.add(daughter);
        person.setMother(mother);
        person.setFather(father);
        person.setChildren(vadikChildren);

        File file = new File("D://vadik.dat");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Person vadik = (Person) objectInputStream.readObject();

        System.out.println(person);
        System.out.println(vadik);






    }
}
