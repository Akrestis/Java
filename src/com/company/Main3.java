package com.company;

public class Main3 {

    public static void main(String[] args) {

        //4) Написать метод который вернет String в которой будут в одну строку числа от 1 до 30.
        //Каждое число при этом взять в круглые скобки ()

        System.out.println(MyString());
    }

    public static String MyString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 31; i++) {
            sb.append("(" + i + ") ");
        }
        return sb.toString();
    }
}
