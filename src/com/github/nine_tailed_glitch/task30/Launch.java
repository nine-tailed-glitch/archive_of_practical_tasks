package com.github.nine_tailed_glitch.task30;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.ArrayList;
import java.util.List;

public class Launch extends AbstractLaunch {

    private List<TranslationKey> keys = new ArrayList<>();

    @Override
    public void start() {

        // расположение: просто в порядке убывания arabic (тех, которые важны)
        keys.add(new TranslationKey(1000, "M"));
        keys.add(new TranslationKey(900, "CM"));
        keys.add(new TranslationKey(500, "D"));
        keys.add(new TranslationKey(400, "CD"));
        keys.add(new TranslationKey(100, "C"));
        keys.add(new TranslationKey(90, "XC"));
        keys.add(new TranslationKey(50, "L"));
        keys.add(new TranslationKey(40, "XL"));
        keys.add(new TranslationKey(10, "X"));
        keys.add(new TranslationKey(9, "IX"));
        keys.add(new TranslationKey(5, "V"));
        keys.add(new TranslationKey(4, "IV"));
        keys.add(new TranslationKey(1, "I"));


        // быстрая сверка данных (а-ля тесты)
        List<Integer> values = new ArrayList<>();
        for (int i = 1; i <= 21; i++) {
            values.add(i);
        }
        values.add(3999);
        values.add(39);
        values.add(40);
        values.add(98);


        for (Integer value : values) {
            String str = convertArabicToRoman(value);
            Integer num = convertRomanToArabic(str);
            System.out.printf("%d\t%s\t%d\t%b\n", value, str, num, value.equals(num));
        }
    }

//      В настоящее время в римской системе счисления используются следующие знаки:
//      I = 1; V = 5; X = 10; L = 50; C = 100; D = 500; M = 1000.
//      Все целые числа от 1 до 3999 записываются с помощью приведенных выше цифр. При этом:
//          + если большая цифра стоит перед меньшей, они складываются: VI = 5 + 1 = 6; XV = 10 + 5 = 15; LX = 50 + 10 = 60; CL = 100 + 50 = 150;
//          + если меньшая цифра стоит перед большей (в этом случае она не может повторяться), то меньшая вычитается из большей; вычитаться могут только цифры, обозначающие 1 или степени 10;
//              уменьшаемым может быть только цифра, ближайшая в числовом ряду к вычитаемой: IV = 5 - 1 = 4; IX = 10 - 1 = 9; XL = 50 - 10 = 40; XC = 100 - 10 = 90;
//          + цифры V, L, D не могут повторяться; цифры I, X, C, M могут повторяться не более трех раз подряд: VIII = 8; LXXX = 80; DCCC = 800; MMMD = 3500.
//          + (не используется т.к. здесь [1;3999]) черта над цифрой увеличивает ее значение в 1 000 раз

    private int convertRomanToArabic(String num) {

        StringBuilder sbNum = new StringBuilder(num);

        int res = 0;
        while (sbNum.length() > 0) {    // переводим до тех пор пока строка не закончится (т.е. пока не распознаем все цифры)
            for (TranslationKey key : keys) {

                String substring;
                if (key.getRoman().length() <= sbNum.length()) {    // проверка (по длине) сможем ли достать подстроку для проверки
                    substring = sbNum.substring(0, key.getRoman().length());
                }
                else {
                    continue;
                }

                if (substring.equals(key.getRoman())) { // совпадает ли подстрока с ключом
                    sbNum.delete(0, key.getRoman().length());   // удаляем опознанный (-ые) символ (-ы)
                    res += key.getArabic(); // последовательно суммируем значения
                }
            }
        }
        return res;
    }

    private String convertArabicToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new RuntimeException("Ошибка преобразования, граница преобразования [1, 3999]");
        }

        StringBuilder res = new StringBuilder(); // результат
        int index = 0; // текущий элемент keys

        while (index < keys.size()) {   // пока не проверим все варианты keys[index]

            while (num >= keys.get(index).getArabic()) {    // делаем раскладываие с сопоставлением
                int currentSeniorRank = num / keys.get(index).getArabic();  // старший разряд

                num %= keys.get(index).getArabic();   // отбрасываем старший разряд

                // делаем дублирвоание значения roman (сколько раз нам нужно его повторить)
                for (int i = 0; i < currentSeniorRank; i++) {
                    res.append(keys.get(index).getRoman());
                }
            }
            index++;

        }

        return res.toString();
    }

    private class TranslationKey {
        private int arabic;
        private String roman;

        TranslationKey(int arabic, String roman) {
            this.arabic = arabic;
            this.roman = roman;
        }

        int getArabic() {
            return arabic;
        }

        String getRoman() {
            return roman;
        }
    }

/*
    private String convertArabicToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new RuntimeException("Ошибка преобразования, граница преобразования [1, 3999]");
        }
        String[] keys = new String[] {  "M",    "CM",   "D",    "CD",   "C",    "XC",   "L",    "XL",   "X",    "IX",   "V",    "IV",   "I" };
        int[] vals = new int[] {        1000,   900,    500,    400,    100,    90,     50,     40,     10,     9,      5,      4,      1 };

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
    */
}