package com.company;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Alex", 22);
        System.out.println(person);

        setParameters(person, "Ben", 33);
        System.out.println(person);
    }

    private static void setParameters(Person person, String name, int age) {
        try {
            Field fieldName = person.getClass().getDeclaredField("name");
            fieldName.setAccessible(true);
            fieldName.set(person, name);
            Field fieldAge = person.getClass().getDeclaredField("age");
            fieldAge.setAccessible(true);
            fieldAge.set(person, age);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
