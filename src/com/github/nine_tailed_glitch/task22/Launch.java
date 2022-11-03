package com.github.nine_tailed_glitch.task22;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        int arraySize = 30;
        int[] array = new int[arraySize];
        //границы генерации
        int min = 1, max = 20;

        fillingArray(array, min, max);

        // используем collection для упрощения решения
        /*
        * set - для решения основной задачи
        * map - для себя (хоть и можно его юзать для ответа на основную задачу), подсчет: сколько раз каждый элемент встречается
        * */
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);

            int numberMeetings = map.getOrDefault(array[i], 0);
            map.put(array[i], numberMeetings + 1);
            // or: map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        System.out.printf("Количество разных элементов %d\n", set.size());
        System.out.println();
        System.out.println("Карта элементов:");
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            System.out.printf("\tЭлемент %d \t- %d раз\n", item.getKey(), item.getValue());
        }


    }
}
