package com.company;

public class Main3 {

    public static void main(String[] args) {

        //3*. Дана строк состоящая из любых символов.
        //Не используя стандартный метод String.toLowerCase() перевести все большие латинские буквы в маленькие.

        String startString = "#1AmC";
        System.out.println(toLowerCase(startString));
    }

    private static String toLowerCase(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 65 && string.charAt(i) <= 90) {
                char ch = string.charAt(i);
                sb.append(ch + 32);
            } else {
                sb.append(string.charAt(i));
            }
        }
        return sb.toString();
    }
}
