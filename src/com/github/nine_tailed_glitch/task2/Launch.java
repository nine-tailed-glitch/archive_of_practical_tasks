package com.github.nine_tailed_glitch.task2;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {

    @Override
    public void start() {
        int arraySize = 5;
        int[] array = new int[arraySize];
        //границы генерации
        int min = 50, max = 120;

        fillingArray(array, min, max);

        //сортировка
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        printArray(array);
    }
}
