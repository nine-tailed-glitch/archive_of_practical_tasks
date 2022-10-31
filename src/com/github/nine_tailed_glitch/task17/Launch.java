package com.github.nine_tailed_glitch.task17;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.Scanner;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();

        int remainder = a;
        int quotient = 0;
        while (remainder >= b) {
            remainder -= b;
            quotient++;
        }

        System.out.printf("%d : %d = %d (ост. = %d)", a, b, quotient, remainder);

    }
}
