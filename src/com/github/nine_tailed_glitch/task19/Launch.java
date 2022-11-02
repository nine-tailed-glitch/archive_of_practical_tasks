package com.github.nine_tailed_glitch.task19;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.Scanner;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            if (isSimple(i))
            {
                System.out.printf("%d ", i);
            }
        }
    }

    // изменение модификаторов для внешних вызовов
    public static boolean isSimple(int n) {
        if (n < 2)
            return false;
        double sqrt = Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
