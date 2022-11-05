package com.github.nine_tailed_glitch.task27;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        int value = 199443;

//        System.out.println(Integer.toHexString(value));

        StringBuilder stringBuilder = new StringBuilder();
        while (value >= 16) {
            stringBuilder.append(getHexValue(value % 16));
            value /= 16;
        }
        stringBuilder.append(getHexValue(value));
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }

    private String getHexValue(Integer decimalValue) {
        if (decimalValue >= 0 && decimalValue <= 9) {
            return decimalValue.toString();
        }
        else if (decimalValue > 9 && decimalValue <= 15) {
            return Character.toString((char)(97 + decimalValue % 10));
//            switch (decimalValue) {
//                case 10:
//                    return "A";
//                case 11:
//                    return "B";
//                case 12:
//                    return "C";
//                case 13:
//                    return "D";
//                case 14:
//                    return "E";
//                case 15:
//                    return "F";
//            }
        }
        throw new RuntimeException("Не определено значение");
    }
}
