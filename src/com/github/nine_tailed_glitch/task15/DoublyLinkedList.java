package com.github.nine_tailed_glitch.task15;

import com.github.nine_tailed_glitch.general.Data;

public class DoublyLinkedList {
    private ListItem firstItem;
    private ListItem lastItem;
    private int countItems;

    public DoublyLinkedList() {
        firstItem = null;
        lastItem = null;
        countItems = 0;
    }

    public void add(Data data) {
        ListItem newItem = new ListItem(data, null, null);
        if (size() == 0) {
            firstItem = newItem;
            lastItem = firstItem;
            countItems++;
            return;
        }

        lastItem.setNext(newItem);
        newItem.setPrev(lastItem);
        lastItem = newItem;

        countItems++;
    }

    public Data getNextFirst() {
        if (size() > 0) {
            ListItem oldItem = firstItem;
            firstItem = firstItem.getNext();
            if (firstItem != null)
                firstItem.setPrev(null);

            countItems--;

            return oldItem.getData();
        }
        throw new NullPointerException("Список пуст");
    }

    public Data getNextLast() {
        if (size() > 0) {
            ListItem oldItem = lastItem;
            lastItem = lastItem.getPrev();
            if (lastItem != null)
                lastItem.setNext(null);

            countItems--;

            return oldItem.getData();
        }
        throw new NullPointerException("Список пуст");
    }


    public int size() {
        return countItems;
    }
}
