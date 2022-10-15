package com.github.nine_tailed_glitch.task14;

import com.github.nine_tailed_glitch.general.AbstractLaunch;

public class Launch extends AbstractLaunch {
    @Override
    public void start() {
        SinglyLinkedList<Data> list = new SinglyLinkedList<>();

        try {
            list.add(new Data(1));
            list.add(new Data(2));
            list.add(new Data(3));
            list.add(new Data(4));
            while (true) {
                System.out.println(list.getNext());

                if (list.size() == 0)
                    break;
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


    }
}
