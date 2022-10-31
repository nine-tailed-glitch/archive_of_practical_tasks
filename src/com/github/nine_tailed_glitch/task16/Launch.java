package com.github.nine_tailed_glitch.task16;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.Scanner;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();

        int p = 0;
        for (int i = 0; i != b; i++) {  // по условию < и > нельзя, берем !=
            p += a;
        }

        System.out.printf("Произведение %d x %d = %d", a, b, p);
    }
}
