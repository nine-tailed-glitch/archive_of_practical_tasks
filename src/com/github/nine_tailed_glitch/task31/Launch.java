package com.github.nine_tailed_glitch.task31;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        printRectangle();
    }

    // прямоугольник
    private void printRectangle() {
        int length = 3;
        int width = 7;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("\u002B\u0020");   // "+[space]" in hex
            }
            System.out.println();
        }
        System.out.println();
    }
}
