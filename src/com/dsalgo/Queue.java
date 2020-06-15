package com.dsalgo;

import java.util.Arrays;

public class Queue {
    private int[] items;
    private int rear;
    private int front;
    private int count;

    public Queue (int capacity) {
        this.items = new int[capacity];
    }

    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException();

        items[rear++] = item;
        count++;
    }

    public int deQueue() {
        var item = items[front];
        items[front++] = 0;
        count--;
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
