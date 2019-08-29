package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        //2*) Iterator

        int[][] arr = {
                {1,2,5},
                {2,3},
                {1,3,4,7}
        };

        Iterator iterator = new Iterator(arr);
        List<Integer> list = new ArrayList<>();
        while(iterator.hasNext()) {
            list.add(iterator.next());
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
