package com.company;

public class Object {

    private int number;
    private String name;

    public Object(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return number + " " + name;
    }
}
