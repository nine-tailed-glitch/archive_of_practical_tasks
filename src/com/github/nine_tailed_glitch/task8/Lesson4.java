package com.github.nine_tailed_glitch.task8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class Lesson4 {
    Lesson4() {
        String htmlFile = parseFile("data/task8/code.html");

        Document doc = Jsoup.parse(htmlFile);
        Elements elements = doc.select("a.tm-nav-item-link");
        elements.forEach(System.out::println);
        System.out.println();
        elements.forEach(element -> System.out.println(element.text()));

//        System.out.println(htmlFile);

    }

    private String parseFile(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line).append("\n"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }


        return builder.toString();
    }
}
