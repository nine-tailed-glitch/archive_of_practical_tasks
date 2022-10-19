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

    public Data get(int index) {
        if (size() > 0) {

            if (index < 0 || index >= size()) {
                throw new IllegalArgumentException("Недопустимый индекс");
            }

            if (index < size() / 2) { // достаем через отсчет от первого

                ListItem itemGet = null;
                ListItem itemCurrent = firstItem;
                for (int i = 0; i < index; i++) {
                    itemCurrent = itemCurrent.getNext();
                }
                itemGet = itemCurrent.getNext();
                if (itemGet == firstItem) {
                    firstItem = firstItem.getNext();
                    firstItem.setPrev(null);
                }
                else {
                    // todo: соеденить предыдущий и следующий
                }

            }
            else { // достаем через отсчет от последнего
                // todo: не забыть сделать расчет верной позиции
            }
        }
        throw new NullPointerException("Список пуст");
    }


    public int size() {
        return countItems;
    }
}
