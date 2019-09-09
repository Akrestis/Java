package com.company;

import com.google.gson.Gson;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Пользователь вводит дату в консоли, программа должна вывести курс USD за эту дату или сообщение об ошибке.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input date in format dd.mm.yyyy");
        String input = scanner.nextLine();
        String URL = "https://api.privatbank.ua/p24api/exchange_rates?json&date=" + input;

        String json = HttpUtil.sendRequest(URL, null, null);
        Gson gson = new Gson();

        Response response = gson.fromJson(json, Response.class);
        for (Value rate : response.getExchangeRate()) {
            if ("USD".equals(rate.getCurrency())) {
                System.out.println("Sale rate: " + rate.getSaleRateNB() + '\n'
                        + "Purchase rate: " + rate.getPurchaseRateNB());
                break;
            }
        }
    }
}
