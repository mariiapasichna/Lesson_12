package com.javaelementary;

import java.util.Arrays;

public class Iterator {
    private int[][] arr;
    private int[] arr2;
    private int size;
    private int current;

    public Iterator(int[][] arr) {
        this.arr = arr;
        this.current = -1;
        this.size = getSize();
        this.arr2 = createIterableArray();
    }

    public boolean hasNext() {
        return current < size - 1;
    }

    public int next() {
        return arr2[++current];
    }

    private int[] createIterableArray() {
        int[] arr2 = new int[size];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, arr2, index, arr[i].length);
            index += arr[i].length;
        }
        Arrays.sort(arr2);
        return arr2;
    }

    private int getSize() {
        for (int i = 0; i < arr.length; i++) {
            size += arr[i].length;
        }
        return size;
    }
}