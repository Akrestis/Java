package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Collections;

public class Main1 {

    public static void main(String[] args) throws FileNotFoundException {

        //1.) Есть документ со списком URL:
        //Вывести топ 10 доменов которые встречаются чаще всего.
        // В документе могут встречается пустые и недопустимые строки.

        topUrls("urls.txt");
    }

    private static void topUrls(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        Map<String, Integer> map = new HashMap<>();
        while (scanner.hasNextLine() && scanner.nextLine() != null) {
            String line = scanner.nextLine().replaceAll(" ", "") + "/";
            int index = line.indexOf('/');
            String url = line.substring(0, index);
            if (map.containsKey(url)) {
                map.put(url, map.get(url) + 1);
            } else {
                map.put(url, 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        Collections.reverse(list);
        list = list.subList(0, 10);

        for (Integer i : list) {
            for (Object tmp : map.keySet()) {
                if (map.get(tmp).equals(i)) {
                    System.out.println(tmp + "  " + map.get(tmp));
                }
            }
        }
    }
}