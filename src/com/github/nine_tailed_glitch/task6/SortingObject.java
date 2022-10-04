package com.github.nine_tailed_glitch.task6;

public class SortingObject {
    private String name;
    private int sortValue;

    public SortingObject(String name, int sortValue) {
        this.name = name;
        this.sortValue = sortValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSortValue() {
        return sortValue;
    }

    public void setSortValue(int sortValue) {
        this.sortValue = sortValue;
    }

    @Override
    public String toString() {
        return String.format("name object: %s\tsort-value: %d", name, sortValue);
    }
}
