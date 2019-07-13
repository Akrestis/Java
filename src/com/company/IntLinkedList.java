package com.company;

import java.util.Arrays;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    private static class Entry {

        int value;
        Entry previous;
        Entry next;

        public Entry(int value) {
            this.value = value;
        }
    }

    private int size = 0;
    private Entry first = null;
    private Entry last = null;

    @Override
    public void add(int element) {
        Entry newEntry = new Entry(element);
        if (size == 0) {
            first = newEntry;
            last = newEntry;
        } else {
            last.next = newEntry;
            newEntry.previous = last;
            last = newEntry;
        }
        size++;
    }

    @Override
    public boolean add(int index, int element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("incorrect index");
        }
        if (index == size) {
            add(element);
        } else if (index == size - 1) {
            add(last.value);
            last.previous.value = element;
        } else {
            add(last.value);
            Entry current = last;
            for (int i = size - 2; i > index; i--) {
                current = current.previous;
                current.value = current.previous.value;
            }
            current.previous.value = element;
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        first = last = null;
    }

    @Override
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("incorrect index");
        }
        if (index < (size >> 1)) {
            Entry current = first;
            if (index == 0) {
                return current.value;
            } else {
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                return current.value;
            }
        } else {
            Entry current = last;
            if (index == size - 1) {
                return current.value;
            } else {
                for (int i = size - 1; i > index; i--) {
                    current = current.previous;
                }
                return current.value;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean removeByIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("incorrect index");
        }
        if (index < (size >> 1)) {
            Entry current = first;
            if (index == 0) {
                current.next.previous = null;
                first = current.next;
            } else {
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
        } else {
            Entry current = last;
            if (index == size - 1) {
                current.previous.next = null;
                last = current.previous;
            } else {
                for (int i = size - 1; i > index; i--) {
                    current = current.previous;
                }
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        Entry current = first;
        while (current.value != value) {
            if (current.next == null) {
                return false;
            } else {
                current = current.next;
            }
        }
        if (current.previous == null) {
            current.next.previous = null;
            first = current.next;
        } else if (current.next == null) {
            current.previous.next = null;
            last = current.previous;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
        return true;
    }

    @Override
    public boolean set(int index, int element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("incorrect index");
        }
        if (index < (size >> 1)) {
            Entry current = first;
            if (index == 0) {
                current.value = element;
            } else {
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                current.value = element;
            }
        } else {
            Entry current = last;
            if (index == size - 1) {
                current.value = element;
            } else {
                for (int i = size - 1; i > index; i--) {
                    current = current.previous;
                }
                current.value = element;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        if (fromIndex >= size || fromIndex < 0 || toIndex >= size || toIndex < 0 || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("incorrect index");
        }
        IntList subList = new IntLinkedList();
        Entry current = first;
        for (int i = 0; i < fromIndex; i++) {
            current = current.next;
        }
        for (int i = fromIndex; i <= toIndex; i++) {
            subList.add(current.value);
            current = current.next;
        }
        return subList;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Entry current = first;
        for (int i = 0; i < size; i++) {
            result[i] = current.value;
            current = current.next;
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public boolean push(int value) {
        add(0, value);
        return true;
    }

    @Override
    public int pop() {
        int value = first.value;
        removeByIndex(0);
        return value;
    }

    @Override
    public int peek() {
        return first.value;
    }

    @Override
    public int remove() {
        int value = last.value;
        removeByIndex(size - 1);
        return value;
    }

    @Override
    public int element() {
        return last.value;
    }
}
