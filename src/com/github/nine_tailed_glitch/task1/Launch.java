package com.github.nine_tailed_glitch.task1;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {

    @Override
    public void start() {
        int arraySize = 5;
        int[] array = new int[arraySize];
        //границы генерации
        int min = 50, max = 120;

        fillingArray(array, min, max);

        // поиск искомых элементов
        int minElementInArr = array[0];
        int maxElementInArr = array[0];
        float avgArr = 0f;
        for (int el : array) {
            if (maxElementInArr < el)
                maxElementInArr = el;
            if (minElementInArr > el)
                minElementInArr = el;
            avgArr += el;
        }
        avgArr /= array.length;
        System.out.format("max: %d \t min: %d \t avg: %.2f", maxElementInArr, minElementInArr, avgArr);
    }
}
