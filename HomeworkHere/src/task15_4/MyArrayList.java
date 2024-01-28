package task15_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<T> {
    private Object[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENT = {};


    public MyArrayList(int capacity) {
        if (capacity > 0) {
            list = new Object[capacity];
        } else if (capacity == 0) {
            list = EMPTY_ELEMENT;
        } else {
            throw new IllegalArgumentException("Capacity < 0");
        }
    }

    public MyArrayList() {
        list = new Object[DEFAULT_CAPACITY];
    }

    public void add(Object item) {
        if (size >= list.length) {
            grow();
        }
        list[size++] = item;
    }

    public void add(int index, Object item) {
        if (index < 0) {
            return;
        }
        if (size + 1 > list.length) {
            grow();
        }
        if (index > size) {
            index = size;
        }
        for (int i = size; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = item;
        size++;
    }

    private void grow() {
        size = size * 2;
        Object[] newList = new Object[size];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
            list[i] = null;
        }
        list = newList;
    }

    public void remove(int index) {
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    public Object get(int index) {
        return list[index];
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (list[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(list[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
}
