package com.company;

import com.google.gson.Gson;

public class Main {

    private final static String URL = "https://postman-echo.com/post";
    private final static String request = "foo1=bar1&foo2=bar2";

    public static void main(String[] args) {

        //1) Послать POST запрос на https://postman-echo.com/post где в
        //BODY передать foo1=bar1&foo2=bar2 в формате x-www-form-urlencoded
        //Ответ распарсить и вывести.

        String json = HttpUtil.sendRequest(URL, null, request);
        Gson gson = new Gson();
        Response response = gson.fromJson(json, Response.class);
        System.out.println(response);
    }
}
