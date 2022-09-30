package com.github.nine_tailed_glitch.task4;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.ArrayList;
import java.util.LinkedList;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        final int N = 1_000_000;
        final int M = 100_000;

        // заполнение
        for (int i = 0; i < N; i++) {
            arrayList.add(rnd(13, 26));
            linkedList.add(rnd(13, 26));
        }

        // замеры
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            arrayList.add((int)(Math.random() * (N - 1)));
        }
        System.out.format("ArrayList: %d \n", System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            linkedList.add((int)(Math.random() * (N - 1)));
        }
        System.out.format("LinkedList: %d \n", System.currentTimeMillis() - startTime);

    }
}
