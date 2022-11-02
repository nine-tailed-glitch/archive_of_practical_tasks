package com.github.nine_tailed_glitch.task21;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import java.util.Scanner;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        // ввод данных
        Scanner scanner = new Scanner(System.in);
        System.out.print("Количество отрезков: ");
        final int n = scanner.nextInt();

        LineSegment[] lines = new LineSegment[n];
        int x, y;
        for (int i = 0; i < n; i++) {
            System.out.printf("Введите координаты отрезка %d:\n", (i + 1));
            Point[] points = new Point[2];
            for (int j = 0; j < 2; j++) {
                System.out.printf("Вершина %d:\n", (j + 1));
                System.out.print("x = ");
                x = scanner.nextInt();
                System.out.print("y = ");
                y = scanner.nextInt();
                points[j] = new Point(x, y);
            }
            lines[i] = new LineSegment(points[0], points[1]);
        }

        // вывод длин отрезков
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("Длина отрезка %d: %f\n", (i + 1), lines[i].lengthLineSegment);
        }

        //расчет полных вхождений
        int[][] entryMatrix = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++) {
                entryMatrix[i][j] = (int) Math.floor(lines[j].lengthLineSegment / lines[i].lengthLineSegment);
            }
        }

        // вывод результата
        System.out.println("\nКоличество полных вхождений каждого в каждый:");
        for (int i = 0; i < n; i++)
        {
            System.out.printf("Отрезок %d:\n", (i + 1));
            for (int j = 0; j < n; j++) {
                System.out.printf("\tв отрезок %d входит %d раз\n", (j + 1), entryMatrix[i][j]);
            }
        }

    }

    private class LineSegment {
        Point vertexA;
        Point vertexB;
        double lengthLineSegment;

        LineSegment(Point vertexA, Point vertexB) {
            this.vertexA = vertexA;
            this.vertexB = vertexB;
            lengthLineSegment = Math.sqrt(Math.pow(vertexB.x - vertexA.x, 2) + Math.pow(vertexB.y - vertexA.y, 2));
        }
    }

    private class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
