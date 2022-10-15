package com.github.nine_tailed_glitch.task14;

class ListItem<T> {
    private T data;
    private ListItem next;

    public ListItem(T data, ListItem next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public ListItem getNext() {
        return next;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }
}
