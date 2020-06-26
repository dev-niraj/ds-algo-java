package com.dsalgo;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Stack;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node (int value) {
            this.value = value;
        }
    }
    private Node head;
    private Node last;
    private int size;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            head = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            head = last = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public int indexOf(int item) {
        var current = head;
        int index = 0;

        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (head == last)
            head = last = null;
        else {
            var second = head.next;
            head.next = null;
            head = second;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (head == last) {
            head = last = null;
        } else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    private Node getPrevious(Node node) {
        var current = head;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = head;
        var index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        var previous = head;
        var current = head.next;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
    }

    public int getKthNodeFromEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var a = head;
        var b = head;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    public void getMaxMin() {
        if (isEmpty())
            throw new IllegalStateException();

        var current = head;

        while (current != null) {
            if(current.value > max) {
                max = current.value;
            }

            if(current.value < min) {
                min = current.value;
            }

            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }

    public void display() {
        var current = head;
        System.out.println();

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}
