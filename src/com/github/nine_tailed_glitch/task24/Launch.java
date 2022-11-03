package com.github.nine_tailed_glitch.task24;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        int a = 4, b = 3;
        int[][] matrixM = new int[a][b];

        int c = 3, d = 3;
        int[][] matrixN = new int[c][d];

        if (b != c) {
            System.out.println("Матрицы не согласованы");
            return;
        }

        //границы генерации
        int min = 10, max = 30;

        System.out.println("(M)");
        fillingMatrix(matrixM, min, max);
        System.out.println("\n(N)");
        fillingMatrix(matrixN, min, max);

        int[][] matrixB = new int[a][d];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < d; j++) {
                matrixB[i][j] = 0;
                for (int k = 0; k < b; k++) {
                    matrixB[i][j] += matrixM[i][k] * matrixN[k][j];
                }
            }
        }
        System.out.println("\n(M x N)");
        printMatrix(matrixB);
    }
}
