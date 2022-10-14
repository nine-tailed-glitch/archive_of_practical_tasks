package com.github.nine_tailed_glitch.task14;

public class SinglyLinkedList {
    private ListItem firstItem;
    private int countItems;

    public SinglyLinkedList() {
        firstItem = null;
        countItems = 0;
    }

    public void add(Data data) {
        ListItem newItem = new ListItem(data, null);
        if (firstItem == null) {
            firstItem = newItem;
            countItems++;
            return;
        }

        getLastItem().setNext(newItem);

        countItems++;
    }

    public Data getNext() {
        if (countItems > 0) {
            ListItem oldItem = firstItem;
            firstItem = firstItem.getNext();
            countItems--;
            return oldItem.getData();
        }
        throw new NullPointerException("Список пуст");
    }

    public int size() {
        return countItems;
    }

    private ListItem getLastItem() {
        ListItem currentItem = firstItem;
        while (currentItem.getNext() != null) {
            currentItem = currentItem.getNext();
        }
        return currentItem;
    }
}
