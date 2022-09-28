package com.github.nine_tailed_glitch.task1;

public class Launch {
    public static void start() {
        int arraySize = 5;
        int[] array = new int[arraySize];
        //границы генерации
        int min = 50, max = 120;

        // заполнение массива
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd(min, max);
        }
        printArray(array);

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

    // генерация чисел в диапазоне [min, max]
    private static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    // распечатка массива
    private static void printArray(int... array) {
        System.out.print("Массив: ");
        for (int el : array) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
