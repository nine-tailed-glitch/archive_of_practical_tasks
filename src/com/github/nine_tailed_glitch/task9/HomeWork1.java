package com.github.nine_tailed_glitch.task9;

import java.io.File;
class HomeWork1 {

    private final int NEW_WIDTH = 300;

    void start() {
        String inFolder = "C:\\files_for_testing\\in";
        String outFolder = "C:\\files_for_testing\\out";
        File srcDir = new File(inFolder);

//        final long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

//        //разделение массива
//        final int middle = files.size / 2;
//        File[] files1 = new File[middle];
//        System.arraycopy(files, 0, files1, 0, files1.size);
//        HW1ImageResizer resizer1 = new HW1ImageResizer(files1, NEW_WIDTH, outFolder, start);
////        new Thread(resizer1).start();
//
//        File[] files2 = new File[files.size - middle];
//        System.arraycopy(files, middle, files2, 0, files2.size);
//        HW1ImageResizer resizer2 = new HW1ImageResizer(files2, NEW_WIDTH, outFolder, start);
////        new Thread(resizer2).start();

        final int conditionalRestrictions = Runtime.getRuntime().availableProcessors();
        int border = files.length / conditionalRestrictions;
        for (int i = 0; i < conditionalRestrictions; i++) {
            if (i == conditionalRestrictions - 1)   // последний поток нагрузим остатками, которые не были учтены при расчете border (когда нет целочисленного деления)
            {
                startThread(files, outFolder, border + files.length % conditionalRestrictions, i * border);
                continue;
            }
            startThread(files, outFolder, border, i * border);
        }

//        System.out.format("> Время работы программы: %d ms\n", (System.currentTimeMillis() - start));
    }

    private void startThread(File[] files, String outFolder, int border, int startPos) {
        File[] filesLoc = new File[border];
        System.arraycopy(files, startPos, filesLoc, 0, filesLoc.length);
        HW1ImageResizer resizer = new HW1ImageResizer(filesLoc, NEW_WIDTH, outFolder, System.currentTimeMillis());
        new Thread(resizer).start();
    }
}
