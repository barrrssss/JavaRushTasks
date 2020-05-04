package com.javarush.task.task20.task2001;

import java.io.*;

public class Asset {
    public Asset(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Asset(){};

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void save(PrintWriter printWriter){
        printWriter.println(name);
        printWriter.println(price);
    }

    public void load(BufferedReader bufferedReader) throws IOException {
        name = bufferedReader.readLine();
        price = Double.parseDouble(bufferedReader.readLine());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;

        if (Double.compare(asset.price, price) != 0) return false;
        return name != null ? name.equals(asset.name) : asset.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
