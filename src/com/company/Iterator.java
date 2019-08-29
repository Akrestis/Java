package com.company;

class Iterator {

    private final int[][] arr;
    private int i;
    private int j;

    Iterator(int[][] arr) {
        this.arr = arr;
    }

    int next() {
        int num = arr[i][j];
        j++;
        if (j >= arr[i].length) {
            j = 0;
            i++;
        }
        return num;
    }

    boolean hasNext() {
        return i < arr.length && j < arr[i].length;
    }


}