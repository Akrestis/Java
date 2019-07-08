package com.company;

public class Main {

    public static void main(String[] args) {

        //1. Написать метод numJewelsInStones который принимает 2 параметра:
        //- String jewels: строка, каждый символ который символизирует драгоценный камень, символы уникальны
        //- String stones: строка, каждый символ который символизирует камень.
        //Строки могут состоять только из символов a..zA..Z
        //Метод должне вернуть количество другоценных камней в строке stones.

        System.out.println(numJewelsInStones("aSDf", "aaAAssddSSDDfFfF"));
    }

    private static int numJewelsInStones(String jewels, String stones) {
        int numJewelsInStones = 0;
        if (jewels.matches("[a-zA-Z]*") && stones.matches("[a-zA-Z]*")) {
            for (int i = 0; i < jewels.length(); i++) {
                for (int j = 0; j < stones.length(); j++) {
                    if (jewels.charAt(i) == stones.charAt(j)) {
                        numJewelsInStones++;
                    }
                }
            }
        }
        return numJewelsInStones;
    }
}

