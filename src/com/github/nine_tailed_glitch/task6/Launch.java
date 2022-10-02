package com.github.nine_tailed_glitch.task6;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        int arraySize = 20;
        int[] array = new int[arraySize];
        //границы генерации
        int min = 5, max = 30;

        fillingArray(array, min, max);

        // сортиривка
        final int MAX_VALUE_IN_ARRAY = max; // необходимо знать наибольшее значение массива
        int[] countersArray = new int[MAX_VALUE_IN_ARRAY];  // массив счетчиков

        // заполняем массив счетчиков: сколько раз встречается каждое число
        for (int value : array) {
            countersArray[value]++;
        }

        //по массиву счетчика выстраиваем отсортированную картину
        int indexSource = 0;    // индекс в исходном массиве
        for (int i = 0; i < countersArray.length; i++) {
            for (int j = 0; j < countersArray[i]; j++) {
                array[indexSource] = i;
                indexSource++;
            }
        }
        printArray(array);
    }
}
