package com.github.nine_tailed_glitch.task3;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        method1();
        method2();
    }

    // метод 2: for + метки (просто по приколу, дань уважения к работе на с++ и ассемлере в свое время)
    private void method2() {
        exit_for:
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue exit_for;
                }
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // метод 1: используя обычный for
    private void method1() {
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
