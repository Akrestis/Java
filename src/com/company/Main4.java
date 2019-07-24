package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main4 {

    public static void main(String[] args) {

        //4. Есть List объектов у каждого из которых 2 поля: int и String.
        //Удалить те у которых значения int повторяются(оставить по одному из дубликатов).

        List<Object> list = new ArrayList<>();

        list.add(new Object(1, "one"));
        list.add(new Object(2, "two"));
        list.add(new Object(1, "three"));
        list.add(new Object(4, "four"));
        list.add(new Object(3, "five"));
        list.add(new Object(3, "six"));
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getNumber() == list.get(j).getNumber()) {
                    list.remove(j);
                }
            }
        }
        System.out.println(list);
    }
}
