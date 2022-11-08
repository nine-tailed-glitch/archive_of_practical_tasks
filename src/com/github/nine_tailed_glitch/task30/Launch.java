package com.github.nine_tailed_glitch.task30;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {

        System.out.println(convertArabicToRoman(1));
        System.out.println(convertArabicToRoman(2));
        System.out.println(convertArabicToRoman(3));
        System.out.println(convertArabicToRoman(4));
        System.out.println(convertArabicToRoman(5));
        System.out.println(convertArabicToRoman(6));
        System.out.println(convertArabicToRoman(7));
        System.out.println(convertArabicToRoman(8));
        System.out.println(convertArabicToRoman(9));
        System.out.println(convertArabicToRoman(10));
        System.out.println(convertArabicToRoman(3999));
    }


    private String convertArabicToRoman(int num)
    {
        if (num < 0 || num > 3999) {
            throw new RuntimeException("Ошибка преобразования, граница преобразования [1, 3999]");
        }

        String[] keys = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] vals = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuilder ret = new StringBuilder();
        int ind = 0;

        while(ind < keys.length)
        {
            while(num >= vals[ind])
            {
                int d = num / vals[ind];
                num = num % vals[ind];
                for(int i=0; i<d; i++)
                    ret.append(keys[ind]);
            }
            ind++;
        }

        return ret.toString();
    }

    private String getSymbol(int number) {
        switch (number) {
            case 1:
                return "I";
            case 5:
                return "V";
            case 10:
                return "X";
            case 50:
                return "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";
        }
        throw new RuntimeException("Некорректный символ");
    }
}


/*
* I = 1;
* V = 5;
* X = 10;
* L = 50;
* C = 100;
* D = 500;
* M = 1000.
*
*
*
* */
