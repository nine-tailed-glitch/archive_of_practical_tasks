package com.github.nine_tailed_glitch.task9;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class HW1ImageResizer implements Runnable {

    private File[] files;
    private int newWidth;
    private String outFolder;
    private long startTime;

    public HW1ImageResizer(File[] files, int newWidth, String outFolder, long startTime) {
        this.files = files;
        this.newWidth = newWidth;
        this.outFolder = outFolder;
        this.startTime = startTime;
    }

    @Override
    public void run() {
        try {
            System.out.format("> Старт процесса в %s\n", Thread.currentThread().getName());
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    System.out.format("> Пропуск файла: %s\n", file.getName());
                    continue;
                }

                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));
                BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;

                for (int x = 0; x < newWidth; x++) {
                    for (int y = 0; y < newHeight; y++) {
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        newImage.setRGB(x, y, rgb);
                    }
                }

                File newFile = new File(outFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
            System.out.format("> Конец процесса в %s\n", Thread.currentThread().getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.format("> Время работы: %d ms\n", (System.currentTimeMillis() - startTime));
    }
}
