package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {

        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Contact contact;
        private Customer customer;

        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            String countryName = customer.getCountryName();

            for (Map.Entry<String, String> entry : countries.entrySet()){
                if (entry.getValue().equals(countryName)){
                    return entry.getKey();
                }
            }

            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String fullName = contact.getName();
            String firstName = fullName.split(", ")[1];

            return firstName;
        }

        @Override
        public String getContactLastName() {
            String fullName = contact.getName();
            String lastName = fullName.split(", ")[0];

            return lastName;
        }

        @Override
        public String getDialString() {
            String phoneNumber = contact.getPhoneNumber();
            phoneNumber = phoneNumber.replace("(", "");
            phoneNumber = phoneNumber.replace(")", "");
            phoneNumber = phoneNumber.replace("-", "");

            String result = "callto://" + phoneNumber;

            return result;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}