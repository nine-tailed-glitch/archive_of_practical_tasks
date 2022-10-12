package com.github.nine_tailed_glitch.task12;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

/*
 * - O(n * Log n)
 * */
public class Launch extends AbstractLaunch {

    @Override
    public void start() {
        int arraySize = 10;
        int[] array = new int[arraySize];
        //границы генерации
        int min = 50, max = 120;

        fillingArray(array, min, max);

        //сортировка
        sort(array, 0, array.length - 1);

        printArray(array);
    }

    private void sort(int[] array, int from, int to) {
        if (from < to) {
            int pivot = partition(array, from, to);
            sort(array, from, pivot - 1);
            sort(array, pivot + 1, to);
        }
    }

    // перекидываем элементы
    private int partition(int[] array, int from, int to) {
        int pivot = selectPivot(from, to);
        swap(array, pivot, to);
        int store = from;
        pivot = to;
        for (int i = from; i <= to - 1; i++) {
            if (array[i] <= array[pivot]) {
                swap(array, i, store);
                store++;
            }
        }
        swap(array, store, pivot);
        pivot = store;
        return pivot;
    }

    private void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private int selectPivot(int first, int last) {
        return (first + last) / 2;
    }
}
