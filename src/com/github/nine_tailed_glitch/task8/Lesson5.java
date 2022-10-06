package com.github.nine_tailed_glitch.task8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class Lesson5 {
    void writeFileProperty() {
        Properties properties = new Properties();
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");

        try {
            properties.store(new FileOutputStream("data/task8/config.properties"), "your comment");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readFileProperty() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("data/task8/config.properties"));
            System.out.println(properties.getProperty("key2"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
