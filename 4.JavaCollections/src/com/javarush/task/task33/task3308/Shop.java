package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Shop {
    public int count;
    public double profit;
    public String[] secretData;
    public Goods goods;

    public static class Goods{
        public List<String> names;
    }
}
