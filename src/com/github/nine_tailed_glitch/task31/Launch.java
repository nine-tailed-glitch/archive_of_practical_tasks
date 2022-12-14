package com.github.nine_tailed_glitch.task31;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
//        printRectangle(7, 3);
//        printFourIsoscelesRightTriangles(15);
//        printFourIsoscelesTriangles(10);
    }

    // прямоугольник
    private void printRectangle(int w, int h) {
        for (int i = 0; i < h; i++) {
            printLine(w);
        }
        System.out.println();
    }

    // четыре равнобедренных прямоугольных треугольника
    private void printFourIsoscelesRightTriangles(final int leg) {
        // угол слева вверху
        int tmpLeg = leg;
        while (tmpLeg > 0) {
            printLine(tmpLeg);
            tmpLeg--;
        }
        System.out.println();

        // угол справа снизу
        tmpLeg = 1;
        while (tmpLeg <= leg) {
            printLine(tmpLeg);
            tmpLeg++;
        }
        System.out.println();

        // угол справа вверху
        tmpLeg = leg;
        while (tmpLeg > 0) {
            for (int i = 0; i < leg - tmpLeg; i++) {
                System.out.print("\u0020\u0020"); // "[space][space]" in hex
            }
            printLine(tmpLeg);
            tmpLeg--;
        }
        System.out.println();

        // угол слева снизу
        tmpLeg = 1;
        while (tmpLeg <= leg) {
            for (int i = 0; i < leg - tmpLeg; i++) {
                System.out.print("\u0020\u0020"); // "[space][space]" in hex
            }
            printLine(tmpLeg);
            tmpLeg++;
        }
        System.out.println();
    }

    // напечатать указанное количество символов (разделенных пробелами)
    private void printLine(int countSymbols) {
        for (int i = 0; i < countSymbols; i++) {
            System.out.print("\u002B\u0020"); // "+[space]" in hex
        }
        System.out.println();
    }


    private void printFourIsoscelesTriangles(final int leg) {
        // обычный равнобедренный треугольник
        int countSymbol = 1;
        for (int i = 0; i < leg; i++) {
            for (int j = 0; j < leg - countSymbol; j++) {
                System.out.print("\u0020\u0020"); // "[space][space]" in hex
            }

            printLine(countSymbol + (countSymbol - 1));
            countSymbol++;
        }
        System.out.println();

        // обычный перевернутый равнобедренный треугольник
        countSymbol = leg;
        for (int i = 0; i < leg; i++) {
            for (int j = 0; j < leg - countSymbol; j++) {
                System.out.print("\u0020\u0020"); // "[space][space]" in hex
            }

            printLine(countSymbol + (countSymbol - 1));
            countSymbol--;
        }
        System.out.println();

        // обычный повернутый вправо равнобедренный треугольник
        final int countLine = leg * 2 - 1;
        countSymbol = 1;
        for (int i = 0; i < countLine; i++) {
            for (int j = 0; j < countSymbol; j++) {
                System.out.print("\u002B\u0020"); // "+[space]" in hex
            }
            System.out.println();

            if (i < countLine / 2)
                countSymbol++;
            else
                countSymbol--;
        }

        // обычный повернутый влево равнобедренный треугольник
        for (int i = 0; i < countLine; i++) {
            for (int j = 0; j < leg - countSymbol - 1; j++) {
                System.out.print("\u0020\u0020"); // "[space][space]" in hex
            }

            for (int j = 0; j <= countSymbol; j++) {
                System.out.print("\u002B\u0020"); // "+[space]" in hex
            }
            System.out.println();

            if (i < countLine / 2)
                countSymbol++;
            else
                countSymbol--;
        }

    }

}
