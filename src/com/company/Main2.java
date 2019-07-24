package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws FileNotFoundException {

        //2. Задан текстовый файл. Вывести сколько в нём: a) строк b) слов c) символов

        getWordCount("test.txt");
    }

    private static void getWordCount(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int lines = 0;
        int words = 0;
        int characters = 0;

        while (scanner.hasNextLine()) {
            lines++;
            String[] array = scanner.nextLine().split(" ");
            words += array.length;
            for (String s : array) {
                characters += s.toCharArray().length;
            }
        }
        System.out.println("Number of lines: " + lines);
        System.out.println("Number of words: " + words);
        System.out.println("Number of characters: " + characters);
        scanner.close();
    }
}
