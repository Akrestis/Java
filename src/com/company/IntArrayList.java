package com.company;

import java.util.Arrays;

public class IntArrayList implements IntList {

    private int[] arr = new int[10];
    private int size = 0;

    @Override
    public void add(int element) {
        if (size >= arr.length) {
            newArray();
        }
        arr[size] = element;
        size++;
    }

    @Override
    public boolean add(int index, int element) {
        if (index > size) {
            return false;
        }
        if (size + 1 == arr.length) {
            newArray();
        }
        System.arraycopy(arr, index, arr, index + 1, size - index + 1);
        size++;
        arr[index] = element;
        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int get(int index) {
        if (size <= index) {
            return 0;
        } else {
            return arr[index];
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        if (size < index) {
            return false;
        } else {
            System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
            size--;
            return true;
        }
    }

    @Override
    public boolean removeByValue(int value) {
        if (size > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == value) {
                    remove(i);
                    i--;
                }
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, int element) {
        if (size < index) {
            return false;
        } else {
            arr[index] = element;
            return true;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList subArr = new IntArrayList();
        int subSize = toIndex - fromIndex + 1;
        for (int i = 0; i < subSize; i++) {
            subArr.add(arr[fromIndex]);
            fromIndex++;
        }
        return subArr;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        System.arraycopy(arr, 0, result, 0, size);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private void newArray() {
        int newSize = arr.length * 3 / 2 + 1;
        int[] newArr = new int[newSize];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }
}
