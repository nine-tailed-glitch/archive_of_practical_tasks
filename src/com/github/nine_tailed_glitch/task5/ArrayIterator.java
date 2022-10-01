package com.github.nine_tailed_glitch.task5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    private int index;

    public ArrayIterator(T[] array) {
        this.array = array;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(); // операция поиска элемента завершилась неудачей
        }
        return array[index++];
    }
}
