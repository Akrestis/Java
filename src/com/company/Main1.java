package com.company;

public class Main1 {

    public static void main(String[] args) {

        //2) Вывести ряд чисел от 1 до 100 через пробел, с изменениями:
        //- если число кратно 3 то вместо него вывести Hello
        //- если число кратно 5 то вместо него вывести World
        //- если число кратно и 3 и 5 то вместо него вывести HelloWorld

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sb.append("HelloWorld ");
            } else if (i % 3 == 0) {
                sb.append("Hello ");
            } else if (i % 5 == 0) {
                sb.append("World ");
            } else {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }
}

