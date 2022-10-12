package com.github.nine_tailed_glitch.task11;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.ArrayList;
import java.util.List;


/*
* - O(Log n)
* - не предусмотрено отсутствие элемента
* - Collections.binarySearch()
* */
public class Launch extends AbstractLaunch {

    private List<String> list;

    @Override
    public void start() {
        list = new ArrayList<>();
        list.add("а");
        list.add("б");
        list.add("в");
        list.add("г");
        list.add("д");
        list.add("е");
        list.add("ж");
        list.add("з");
        list.add("и");

        System.out.format("Индекс искомого элемента: %d", search("г", 0, list.size()));

    }

    private int search(String query, int from, int to) {
        int middle = (from + to) / 2;
        int comparison = query.compareTo(list.get(middle));
        if (comparison == 0) {
            return middle;
        }
        else if (comparison > 0) {
            return search(query, middle, to);
        }
        else {
            return search(query, from, middle);
        }
    }
}
