package com.github.nine_tailed_glitch.task6;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.ArrayList;

public class Launch extends AbstractLaunch {

    @Override
    public void start() {

        //sortingNumericArray();
        sortingObjectArray();
    }

    private void sortingObjectArray() {
        // создание списка объектов
        ArrayList<SortingObject> list = new ArrayList<SortingObject>() {{
            add(new SortingObject("aaa", 7));
            add(new SortingObject("bbb", 2));
            add(new SortingObject("ccc", 7));
            add(new SortingObject("ddd", 3));
            add(new SortingObject("eee", 3));
            add(new SortingObject("fff", 7));
            add(new SortingObject("ggg", 2));
            add(new SortingObject("hhh", 3));
            add(new SortingObject("iii", 3));
            add(new SortingObject("jjj", 7));
            add(new SortingObject("kkk", 2));
        }};

        System.out.println(list.size() + ":");
        for (SortingObject item : list) {
            System.out.println(item);
        }

        // сортировка
        final int MAX_VALUE = 8; // необходимо знать наибольшее значение массива
        int[] countersArray = new int[MAX_VALUE];  // массив счетчиков

        // заполняем массив счетчиков: сколько раз встречается каждое число
        for (SortingObject item : list) {
            countersArray[item.getSortValue()]++;
        }

        // делаем из массива счетчиков массив индексов
        for (int i = 1; i < countersArray.length; i++) {
            countersArray[i] += countersArray[i - 1];
        }

        // по массиву индексов заполняем выходной массив
        SortingObject[] out = new SortingObject[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {    // обратный порядок для устойчивости (чтобы сохранялся исходный порядок при одинаковом сортируемом значении)
            SortingObject obj = list.get(i);
            out[countersArray[obj.getSortValue()] - 1] = obj;
            countersArray[obj.getSortValue()]--;    // готовим место для след. объекта с таким же сорт значением
        }

        System.out.println(out.length + ":");
        for (SortingObject item : out) {
            System.out.println(item);
        }
    }

    private void sortingNumericArray() {
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
