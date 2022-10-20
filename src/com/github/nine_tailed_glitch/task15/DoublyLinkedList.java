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

            decCountItem();

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

            decCountItem();

            return oldItem.getData();
        }
        throw new NullPointerException("Список пуст");
    }

    public Data get(int index) {
        if (size() > 0) {

            if (index < 0 || index >= size()) {
                throw new IllegalArgumentException("Недопустимый индекс");
            }

            if (index < size() / 2) { // достаем через отсчет от первого

                // отсчитываем наш элемент (именно до index - 1)
                ListItem currentItem = firstItem;
                for (int i = 0; i < index; i++) {
                    currentItem = currentItem.getNext();
                }

                // устанавливаем связи
                connectSurroundingElements(currentItem);
                decCountItem();
                return currentItem.getData();

            }
            else { // достаем через отсчет от последнего
                // находим наш элемент
                ListItem currentItem = lastItem;
                for (int i = size() - 1; i > index; i--) {
                    currentItem = currentItem.getPrev();
                }

                // устанавливаем связи
                connectSurroundingElements(currentItem);
                decCountItem();
                return currentItem.getData();
            }
        }
        throw new NullPointerException("Список пуст");
    }

    private void connectSurroundingElements(ListItem currentItem) {
        if (size() > 0) {
            if (currentItem == firstItem) {
                firstItem = firstItem.getNext();
                if (firstItem != null)
                    firstItem.setPrev(null);
            }
            else if (currentItem == lastItem) {
                lastItem = lastItem.getPrev();
                lastItem.setNext(null);
            }
            else {
                ListItem next = currentItem.getNext();
                ListItem prev = currentItem.getPrev();
                prev.setNext(next);
                if (next != null) {
                    next.setPrev(prev);
                }
            }
        }
        else {
            System.out.println("Список пуст");
        }
    }

    public void viewAllFromBeginning () {
        ListItem current = firstItem;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public void viewAllFromEnd () {
        ListItem current = lastItem;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getPrev();
        }
    }

    private void decCountItem() {
        countItems--;
        if (countItems <= 0) {
            firstItem = null;
            lastItem = null;
            countItems = 0;
        }
    }

    public int size() {
        return countItems;
    }
}
