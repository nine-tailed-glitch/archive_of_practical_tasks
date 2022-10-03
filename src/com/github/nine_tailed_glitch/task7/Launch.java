package com.github.nine_tailed_glitch.task7;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        char[] animationChars = new char[] {'-', '\\', '|', '/'};
        for (int i = 0; i <= 100; i++) {
            System.out.format("Processing:\t%d%%\t%c\r", i, animationChars[i % animationChars.length]);

            try {
                Thread.sleep(300);
            }
            catch (InterruptedException ignored) {}
        }
        System.out.println("Processing:\tDone!");
    }
}
