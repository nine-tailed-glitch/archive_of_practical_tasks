package com.github.nine_tailed_glitch.task20;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.Scanner;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        final int n = scanner.nextInt();

        decomposition(n);
    }

    private void decomposition(int n) {
        System.out.printf("Простые множители %d: ", n);
        decomposition(n, 2);
    }

    private void decomposition(int n, int simpleMultiplier) {
        if (n == 1) {
            return;
        }

        if (n % simpleMultiplier == 0) {
            System.out.printf("%d ", simpleMultiplier);

            n /= simpleMultiplier;
            decomposition(n, simpleMultiplier);
        }
        else {
            decomposition(n, getNextSimpleMultiplier(simpleMultiplier));
        }
    }

    private int getNextSimpleMultiplier(int searchStartValue) {
        for (int i = searchStartValue + 1; ; i++) {
            if (com.github.nine_tailed_glitch.task19.Launch.isSimple(i))
                return i;
        }
    }
}
