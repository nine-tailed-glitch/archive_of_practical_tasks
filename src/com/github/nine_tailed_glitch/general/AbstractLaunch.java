package com.github.nine_tailed_glitch.general;

public abstract class AbstractLaunch {
    // заполнение массива
    protected void fillingArray(int[] array, int min, int max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd(min, max);
        }
        printArray(array);
    }

    // генерация чисел в диапазоне [min, max]
    protected int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    // распечатка массива
    protected void printArray(int... array) {
        System.out.print("Массив: ");
        for (int el : array) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public abstract void start();
}
