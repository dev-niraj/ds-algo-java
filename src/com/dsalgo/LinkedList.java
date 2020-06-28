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

    public void deleteLargestElement() {
        if (head == null || head.next == null)
            throw new IllegalStateException();

        var node = head;

        Node prevLargest, largest, current, prev;
        current = largest = node;
        prevLargest = null;
        prev = node;
        node = node.next;

        while (node != null) {
            if (node.value > largest.value) {
                prevLargest = prev;
                largest = node;
            }

            prev = node;
            node = node.next;
        }

        if (current == largest) {
            current = current.next;
        } else {
            prevLargest.next = largest.next;
        }
    }

    public void createLoop() {
        head.next.next.next.next.next.next.next = head.next.next;
    }

    public boolean isLoop() {
        if (isEmpty())
            throw new IllegalStateException();

        var slow = head;
        var fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public int lengthOfLoop() {
        if (isEmpty())
            throw new IllegalStateException();

        var slow = head;
        var fast = head;
        int length = 0;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow == fast) {
            while (slow.next != fast) {
                slow = slow.next;
                length++;
            }
            length++;
        }

        return length;
    }

    public boolean detectAndRemoveLoop() {
        if (isEmpty())
            throw new IllegalStateException();

        var slow = head;
        var fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                removeLoop(slow, head);
                return true;
            }
        }
        return false;
    }

    private void removeLoop (Node loop, Node head) {
        Node ptr1 = loop;
        Node ptr2 = loop;

        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }

        ptr1 = head;
        ptr2 = head;

        for(i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }

        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }

        ptr2.next = null;
    }

    public void deleteMiddleNode() {
        if (head == null || head.next == null)
            throw new IllegalStateException();

        Node slow, fast, prev;
        slow = fast = prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
    }

    public boolean ifPalindrome() {
        if (head == null || head.next == null)
            throw new IllegalStateException();

        Node slow, fast;
        slow = fast = head;

        Stack<Node> stack = new Stack<Node>();
        stack.push(slow);

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow);
        }

        if (fast.next == null) {
            stack.pop();
        }

        Node secondHalf = slow.next;

        while (secondHalf != null) {
            if (stack.pop().value != secondHalf.value) {
                return false;
            }

            secondHalf = secondHalf.next;
        }

        return true;
    }

    public void passNode() {
        if (isEmpty())
            throw new IllegalStateException();

        deleteGivenNode(head.next.next.next);
    }

    private void deleteGivenNode(Node node) {
        if (node == null || node.next == null)
            throw new IllegalStateException();

        node.value = node.next.value;
        node.next = node.next.next;
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
