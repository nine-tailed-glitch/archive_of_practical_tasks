package com.github.nine_tailed_glitch.task15;

import com.github.nine_tailed_glitch.general.AbstractLaunch;
import com.github.nine_tailed_glitch.general.Data;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {

        DoublyLinkedList list = new DoublyLinkedList();
        try {
            for (int i = 0; i < 3; i++) {
                list.add(new Data(0));
                list.add(new Data(1));
                list.add(new Data(2));
                list.add(new Data(3));
                while (true) {
                    System.out.println(list.get(1));

                    if (list.size() == 0)
                        break;
                }
                System.out.println("--------");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
