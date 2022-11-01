package com.github.nine_tailed_glitch.task18;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.Scanner;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        // проверки на коррекность не в теме задания

        System.out.printf("GCD (%d, %d) = %d", a, b, a > b ? gcd(a, b) : gcd(b, a));
    }

    // Евклид
    private int gcd(int more, int less) {
        int remainder = more % less;
        if (remainder == 0) {
            return less;
        }
        return gcd(less, remainder);
    }
}
