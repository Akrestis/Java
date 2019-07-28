package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main3 {

    public static void main(String[] args) {

        //3. Задана строка с датой вида "22.01.2019 19:15:00".
        // Написать метод который преобразовывает ее в формат "22 Jan, 7:15 PM".
        // Предусмотреть обработку ситуации если входящая дата в недопустимом формате.

        String string = "22.01.2019 19:15:00";
        Date date;
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        try {
            date = formatter.parse(string);
            newFormat(date);
        } catch (ParseException e) {
            System.out.println("Wrong date format");
        }
    }

    private static void newFormat (Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, h:mm aa");
        String result = formatter.format(date);
        System.out.println(result);
    }
}
