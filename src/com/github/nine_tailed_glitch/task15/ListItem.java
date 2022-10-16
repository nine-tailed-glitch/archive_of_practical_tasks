package com.github.nine_tailed_glitch.task15;

import com.github.nine_tailed_glitch.general.Data;

class ListItem {
    private Data data;
    private ListItem next;
    private ListItem prev;

    public ListItem(Data data, ListItem next, ListItem prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Data getData() {
        return data;
    }

    public ListItem getNext() {
        return next;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }

    public ListItem getPrev() {
        return prev;
    }

    public void setPrev(ListItem prev) {
        this.prev = prev;
    }
}
