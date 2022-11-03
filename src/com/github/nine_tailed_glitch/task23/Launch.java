package com.github.nine_tailed_glitch.task23;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        int arraySize = 11;
        int[] array = new int[arraySize];
        //границы генерации
        int min = 1, max = 10;

        fillingArray(array, min, max);

        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
        printArray(array);
    }

}
