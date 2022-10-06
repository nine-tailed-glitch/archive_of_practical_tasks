package com.github.nine_tailed_glitch.task8;

import com.github.nine_tailed_glitch.general.AbstractLaunch;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        lesson3();
    }

    private void lesson3() {

        // method 1: PrintWriter
        try {
            PrintWriter writer = new PrintWriter("data/task8/out.txt");

            writer.write("Hello, File\n");

            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void lesson2() {

        StringBuilder builder = new StringBuilder();

        //method 1: stream
        try {
            FileInputStream is = new FileInputStream("data/task8/test.txt");
            for (;;) {
                int code = is.read();

                if (code < 0) {
                    break;
                }

                char ch = (char) code;
//                System.out.print(ch);
                builder.append(ch);
            }
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //method 2: BufferedReader (+: чтение построчно)
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/task8/test.txt"));

            for (;;) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                builder.append(line).append('\n');
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //method 3: class Files (позволяет чтение строк в лист стрингов  и много чего еще)
        try {
            List<String> lines = Files.readAllLines(Paths.get("data/task8/test.txt"));
            lines.forEach(line -> builder.append(line).append('\n'));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(builder);
    }

    private void lesson1() {
        // фалы
        File file = new File("data/task8/test.txt");
        /* заметка по абсолютным путям
        * path Windows: C:\\folder1\\folder2\\file.extension
        *           or: C:/folder1/folder2/file.extension
        * path Linux: /folder1/folder2/file.extension
        * */
        System.out.println(file.length());
        System.out.println(file.lastModified());

        // папки
        File folder = new File("data/task8");
        System.out.println(folder.isDirectory());
        File[] files = folder.listFiles();
        for(File obj : files) {
            System.out.println(obj.getPath());
        }

        //new File("data/task8/newFolder").mkdir()  -> создание папки
    }

}
