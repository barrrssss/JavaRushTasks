package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        StringWriter stringWriter = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();

        marshaller.marshal(obj, stringWriter);

        String xml = stringWriter.toString();

        String result = xml.replaceAll("<" + tagName, "<!--" + comment + "--><" + tagName);

        return result;
    }

    public static void main(String[] args) throws JAXBException {
        Person person = new Person();
        person.name = "Vadik";
        person.age = 25;
        System.out.println(toXmlWithComment(person, "name", "it's a comment"));

    }

    @XmlRootElement
    public static class Person{
        public String name;
        public int age;
    }
}
