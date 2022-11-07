package com.github.nine_tailed_glitch.task29;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.Arrays;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        // исходные значения
        String number1 = "1234";
        String number2 = "13";

        //
        int n;  // длина промежуточных массивов
        int m;  // максимальный уровень промежуточных вычислений
        if (number1.length() > number2.length()) {
            n = number1.length();
            m = number2.length();
        }
        else {
            n = number2.length();
            m = number1.length();
        }
        n += m;
        int[] number1Arr = convertStringNumberToArray(number1);
        int[] number2Arr = convertStringNumberToArray(number2);

        int[] intermediate = new int[n];
        Arrays.fill(intermediate, 0);


        // сам процесс умножения (в столбик)
        int entryLevel = 0;
        int memorization = 0;
        for (int i = number2Arr.length - 1; i >= 0; i--) {
            int index = n - 1 - entryLevel;

            for (int j = number1Arr.length - 1; j >= 0; j--) {
                // само умножение двух чисел
                int mult = number2Arr[i] * number1Arr[j] + memorization;

                // расчет: что записываем + что "держим в уме" + объединение с промежуточными вычислениями
                int sum = intermediate[index] + (mult % 10);
                intermediate[index] = sum % 10;
                intermediate[index - 1] += sum / 10;

                // "оставляем у уме"
                memorization = mult / 10;
                index--;
            }

            intermediate[index] += memorization;
            memorization = 0;

            entryLevel++;
        }

        // вывод
        System.out.println(Arrays.toString(intermediate)); // простой проверочный

        StringBuilder stringBuilder = new StringBuilder();
        boolean isFlag = true; // для отбрасывания незначемых нулей
        for (int item : intermediate) {
            if (item != 0)
                isFlag = false;

            if (isFlag)
                continue;

            stringBuilder.append(item);
        }

        System.out.printf("%s * %s = %s", number1, number2, stringBuilder);
    }

    private int[] convertStringNumberToArray(String number) {
        int[] array = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            array[i] = Integer.parseInt(Character.toString(number.charAt(i)));
        }
        return array;
    }
}
