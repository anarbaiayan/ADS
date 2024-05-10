package org.example;

public class MyQueue<T extends Comparable<T>> {
    MyArrayList<T> queue = new MyArrayList<>();
    public MyQueue() {
    }
    public T front() { // first element
        return queue.get(0);
    }
    public T back() {
        return queue.get(queue.size() - 1);
    } // last element
    public T dequeue() { // gets first element and removes it
        T item = queue.get(0);
        queue.remove(0);
        return item;
    }
    public void enqueue(T item) {// adds elements to the first of the queue
        queue.add(item);
    }
    public boolean isEmpty() { // checks if the queue is empty
        return queue.size() == 0;
    }
    public int size() {// size function
        return queue.size();
    }
    public void clear() {// clear function
        queue.clear();
    }
}
