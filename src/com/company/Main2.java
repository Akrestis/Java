package com.company;

public class Main2 {

    public static void main(String[] args) {

        //2. Написать метод который проверяет число простое или нет. Если нет вывести все его делители.

        isPrime(123);
    }

    private static void isPrime(int number) {
        if (number == 1 || number == 2 || number == 3) {
            System.out.println("Number is prime");
        } else {
            boolean primality = true;
            if (number % 2 == 0) {
                primality = false;
            }
            for (int i = 5; i <= number / 2; i += 2) {
                if (number % i == 0) {
                    primality = false;
                }
                if (!primality) {
                    break;
                }
            }
            if (primality) {
                System.out.println("Number is prime");
            } else {
                System.out.print("Number is not prime. Divisors: ");
                for (int i = 1; i <= number; i++) {
                    if (number % i == 0) {
                        System.out.print(i + "; ");
                    }
                }
            }
        }
    }
}
