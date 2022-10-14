package com.github.nine_tailed_glitch.task14;

class ListItem {
    private Data data;
    private ListItem next;

    public ListItem(Data data, ListItem next) {
        this.data = data;
        this.next = next;
    }

    public Data getData() {
        return data;
    }

//    public void setData(Data data) {
//        this.data = data;
//    }

    public ListItem getNext() {
        return next;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }
}
