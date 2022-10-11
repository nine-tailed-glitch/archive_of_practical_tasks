package com.github.nine_tailed_glitch.task10;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

import javax.swing.*;
import java.awt.*;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);

        frame.setLayout(new FlowLayout());
        frame.add(new JButton("Click me"));



        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
