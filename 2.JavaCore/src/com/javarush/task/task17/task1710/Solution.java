package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormat1 = new SimpleDateFormat("d/MM/yyyy");
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("d-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c": {
                if (args[2].equals(Sex.MALE.title)) {
                    allPeople.add(Person.createMale(args[1], dateFormat1.parse(args[3])));
                } else {
                    allPeople.add(Person.createFemale(args[1], dateFormat1.parse(args[3])));
                }
                System.out.println(allPeople.size() - 1);
                break;
            }
            case "-u": {
                if (args[3].equals(Sex.MALE.title)) {
                    allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], dateFormat1.parse(args[4])));
                } else {
                    allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], dateFormat1.parse(args[4])));
                }
                break;
            }
            case "-d": {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
                break;
            }
            case "-i": {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                System.out.println(String.format("%s %s %s", person.getName(), person.getSex().title, dateFormat2.format(person.getBirthDate())));
                break;
            }
        }
    }

}
