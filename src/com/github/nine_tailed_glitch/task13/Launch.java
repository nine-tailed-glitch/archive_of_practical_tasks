package com.github.nine_tailed_glitch.task13;

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

        sort(array, array.length);

        printArray(array);
    }

    private void sort(int[] array, int n) {
        if (n < 2) {
            return;
        }
        int middle = n / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[n - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = array[i];
        }

        for (int i = middle; i < n; i++) {
            rightArray[i - middle] = array[i];
        }

        sort(leftArray, middle);
        sort(rightArray, n - middle);

        merge(array, leftArray, middle, rightArray, n - middle);
    }

    private void merge(int[] array, int[] leftArray, int leftSize, int[] rightArray, int rightSize) {
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            }
            else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }
        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }
}
