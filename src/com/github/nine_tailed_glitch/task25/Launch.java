package com.github.nine_tailed_glitch.task25;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        int n = 5;
        int[][] matrix = new int[n][n];
        //границы генерации
        int min = 1, max = 9;

        fillingMatrix(matrix, min, max);


//        способ 1 (не по заданию)
//        // ч-з вспомогательную
//        int[][] matrixT = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrixT[i][n - 1 - j] = matrix[j][i];
//            }
//        }
//        printMatrix(matrixT);


//        способ 2
//        // транспонирование
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                int tmp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = tmp;
//            }
//        }
//        // меняем местами стобцы
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n / 2; j++) {
//                int tmp = matrix[i][j];
//                matrix[i][j] = matrix[i][n - 1 - j];
//                matrix[i][n - 1 - j] = tmp;
//            }
//        }
//        printMatrix(matrix);

//        способ 3
        int lineBorder = n % 2 == 0 ? n / 2 : n / 2 + 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < lineBorder; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }

        printMatrix(matrix);

    }
}
