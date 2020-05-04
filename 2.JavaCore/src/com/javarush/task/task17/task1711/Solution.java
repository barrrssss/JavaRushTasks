package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormat1 = new SimpleDateFormat("d/MM/yyyy");
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("d-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]){
            case "-c" : {
                synchronized (allPeople){
                    for (int i = 1; i <= args.length - 3; i += 3){
                        Person person;

                        if (args[i + 1].equals(Sex.MALE.title)) {
                            allPeople.add(person = Person.createMale(args[i], dateFormat1.parse(args[i + 2])));
                        } else {
                            allPeople.add(person = Person.createFemale(args[i], dateFormat1.parse(args[i + 2])));
                        }
                        System.out.println(allPeople.indexOf(person));
                    }
                    break;
                }
            }
            case "-u" : {
                synchronized (allPeople){
                    for (int i = 2; i <= args.length - 3; i += 4){
                        if (args[i + 1].equals(Sex.MALE.title)) {
                            allPeople.set(Integer.parseInt(args[i - 1]), Person.createMale(args[i], dateFormat1.parse(args[i + 2])));
                        } else {
                            allPeople.add(Integer.parseInt(args[i - 1]), Person.createFemale(args[i], dateFormat1.parse(args[i + 2])));
                        }
                    }
                    break;
                }
            }
            case  "-d" : {
                synchronized (allPeople){
                    for (int i = 1; i <= args.length - 1; i++){
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                    break;
                }
            }
            case "-i" : {
                synchronized (allPeople){
                    for (int i = 1; i <= args.length - 1; i++){
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(String.format("%s %s %s", person.getName(), person.getSex().title, dateFormat2.format(person.getBirthDate())));
                    }
                    break;
                }
            }
        }
    }
}
