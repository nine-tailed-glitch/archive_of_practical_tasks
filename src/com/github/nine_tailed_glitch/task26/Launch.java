package com.github.nine_tailed_glitch.task26;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        /*
        * Основная стратегия: каждый очередной камень максимального веса кладется в кучу с меньшим общим весом
        * Если решение сущесвует (т.е. самый тяжелый камень не перевешивает сумму остальных более чем в 2 раза), то вес будет максимально сбалансирован,
        * что соблюдит основное условие
        * */

        int n = 15;
        int[] arraySourceStones = new int[n];
        //границы генерации
        int minWeight = 50, maxWeight = 120;
        fillingArray(arraySourceStones, minWeight, maxWeight);

        // сортировка (используем из прошлых заданий)
        com.github.nine_tailed_glitch.task12.Launch.sort(arraySourceStones);
        printArray(arraySourceStones);

        // сейчас просто выведем вес куч (без указания количества и номеров камней)
        int firstWeight = 0;
        int secondWeight = 0;
        for (int i = arraySourceStones.length - 1; i >= 0; i--) {
            if (firstWeight < secondWeight) {
                firstWeight += arraySourceStones[i];
            }
            else {
                secondWeight += arraySourceStones[i];
            }
        }
        System.out.printf("Вес первой кучи %d\n", firstWeight);
        System.out.printf("Вес второй кучи %d\n", secondWeight);
        if (firstWeight / secondWeight > 2 || secondWeight / firstWeight > 2) {
            System.out.println("Решение не найдено, вес отличаетсяя более, чем в 2 раза");
        }
        else {
            System.out.println("Решение найдено");
        }
    }
}
