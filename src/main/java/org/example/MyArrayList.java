package org.example;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Error: Illegal Capacity");
        arr = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    } // Creates an empty list with default capacity

    private void increaseCapacity() {
        Object[] temp = new Object[arr.length * 2];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    } // Increases the capacity of list

    @Override
    public void add(T item) {
        if (length == arr.length) {
            increaseCapacity();
        }
        arr[length++] = item;
    } // Add new element to the end of the list

    @Override
    public void set(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Error: Index out of bound");
        }
        arr[index] = item;
    } // Replace new element on the specified index with another

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Error: Index out of bound");
        }
        if (length == arr.length) {
            increaseCapacity();
        }
        System.arraycopy(arr, index, arr, index + 1, length - index);
        arr[index] = item;
        length++;
    } // Add new element to the specified index

    @Override
    public void addFirst(T item) {
        add(0, item);
    } // Add new element on the beginning of this list

    @Override
    public void addLast(T item) {
        add(item);
    } // Add new element on the end of this list

    @Override
    public T get(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Error: Index out of bound");
        }
        return (T) arr[index];
    } // Gets element on specified index

    @Override
    public T getFirst() {
        if (length == 0) {
            throw new IndexOutOfBoundsException("Array is empty");
        }
        return (T) arr[0];
    } // Gets first element of the list

    @Override
    public T getLast() {
        if (length == 0) {
            throw new IndexOutOfBoundsException("Array is empty");
        }
        return (T) arr[length - 1];
    } // Gets last element of this list

    @Override
    public void remove(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Error: Index out of bound");
        }
        int num = length - index - 1;
        if (num > 0) {
            System.arraycopy(arr, index + 1, arr, index, num);
        }
        arr[--length] = null;
    } // Removes element from the list on specified index

    @Override
    public void removeFirst() {
        remove(0);
    } // Removes first element from the list

    @Override
    public void removeLast() {
        remove(length - 1);
    } // Removes last element from the list

    @Override
    public void sort() {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length-1-i; j++) {
                if (((Comparable)arr[j]).compareTo(arr[j+1]) > 0) {
                    Object temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    } // Sort the list in asc order

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    } // Returns index of specified element
    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if(arr[i].equals(object)){
                return i;
            }
        }
        return -1;
    } // Returns index of the last element in the list

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    } // Checks for existing of specified element

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[length];
        System.arraycopy(arr, 0, temp, 0, length);
        return temp;
    } // Returns an array

    @Override
    public void clear() {
        arr = new Object[DEFAULT_CAPACITY];
    } // Deletes all elements from the list

    @Override
    public int size() {
        return length;
    } // Returns number of element in list

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public class MyIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < length;
        }

        @Override
        public T next() {
            return (T) arr[index++];
        }
    }
}