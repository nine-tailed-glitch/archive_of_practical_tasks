package com.github.nine_tailed_glitch.task28;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        int n = 5;
        n = fib(n);
        System.out.printf("fib(n) = %d\n", n);
        n = fact(n);
        System.out.printf("fact(n) = %d\n", n);
    }

    // обычное вычисление ч-з динам. програм. т.к. простой код, быстро для малых n (но линейное время)
    // 5 способов fib: https://habr.com/ru/post/261159/
    private int fib(int n) {
        int a = 1;
        int b = 1;
        for (int i = 2; i < n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    // наивный алгоритм
    private int fact(int n) {
        int m = 1;
        for (int i = 2; i <= n; i++) {
            m *= i;
        }
        return m;
    }
}
