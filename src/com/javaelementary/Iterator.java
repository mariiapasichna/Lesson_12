package com.javaelementary;

import java.util.ArrayList;
import java.util.List;

public class Iterator {
    private int[][] arr;
    private int current;
    private int size;
    private List<InnerIterator> iterators;

    public Iterator(int[][] arr) {
        this.arr = arr;
        this.current = -1;
        this.size = getSize();
        this.iterators = createList();
    }

    public boolean hasNext() {
        return current < size - 1;
    }

    public int next() {
        int index = 0;
        int min = 0;
        for (int i = 0; i < iterators.size(); i++) {
            if (iterators.get(i).hasNext()) {
                min = iterators.get(i).getCurrent();
                break;
            }
        }
        for (int i = 0; i < iterators.size(); i++) {
            if (iterators.get(i).hasNext() && iterators.get(i).getCurrent() <= min) {
                min = iterators.get(i).getCurrent();
                index = i;
            }
        }
        current++;
        return iterators.get(index).next();
    }

    private List<InnerIterator> createList() {
        List<InnerIterator> iterators = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            iterators.add(new InnerIterator(arr[i]));
        }
        return iterators;
    }

    private int getSize() {
        for (int i = 0; i < arr.length; i++) {
            size += arr[i].length;
        }
        return size;
    }

    private static class InnerIterator {
        private int[] arr;
        private int current;

        public InnerIterator(int[] arr) {
            this.arr = arr;
            this.current = -1;
        }

        public boolean hasNext() {
            return current < arr.length - 1;
        }

        public int next() {
            return arr[++current];
        }

        public int getCurrent() {
            return arr[current + 1];
        }
    }
}