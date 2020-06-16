package com.dsalgo;

import java.util.NoSuchElementException;
import java.util.Stack;

public class LinkedList {
    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node last;
    private int size;

    public void addLast(int val) {
        var node = new Node(val);

        if (head == null) {
            head = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int val) {
        var node = new Node(val);
        if (head == null) {
            head = last = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = head;

        while (current != null) {
            if (current.val == item) return index;
            current = current.next;
            index++;
        }

        return -1;
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
            last = getPrevious(last);
            last.next = null;
        }

        size--;
    }

    public Node getPrevious(Node node) {
        var current = head;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public void reverseLinkedList() {
        var previous = head;
        var current = head.next;

        last = head;
        last.next = null;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    public int getKthNodeFromEnd(int k) {

        var a = head;
        var b = head;

        for(int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();

        }

        while(b != last) {
            a = a.next;
            b = b.next;
        }

        return a.val;
    }

    public void createLoop() {
        last.next = head.next;
    }

    public boolean detectLoop() {
        return detectLoop(head);
    }

    private boolean detectLoop(Node node) {
        if (node == null) {
            return false;
        }

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

    public int getLengthOfLoop() {
        return getLengthOfLoop(head);
    }

    private int getLengthOfLoop(Node node) {
        if (node == null)
            return -1;

        int length = 0;

        var fast = node;
        var slow = node;

        while (fast.next != null && fast.next.next != null) {
            slow =  slow.next;
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

    public void detectAndRemove() {
        detectAndRemove(head);
    }

    private void detectAndRemove(Node head) {
        if (head == null)
            return;

        var slow = head;
        var fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                removeLoop(slow, head);
            }
        }
    }

    private void removeLoop(Node loop, Node current) {
        Node ptr1 = null, ptr2 = null;

        ptr1 = current;
        while (true) {
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }

            if (ptr2.next == ptr1) {
                break;
            }
            ptr1 = ptr1.next;
        }

        ptr2.next = null;
    }

    public void removeMiddle() {
        removeMiddle(head);
    }

    private void removeMiddle(Node head) {
        var current = head;
        var slow = head;
        var fast = head;
        var prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow  = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
    }

    public void deleteLargest() {
        deleteLargest(head);
    }

    private void deleteLargest(Node root) {
        if (root == null || root.next == null)
            return;

        var node = root;
        var head = node;
        var largest = node;
        var prev = node;
        node = node.next;
        Node prevLargest = null;

        while (node != null) {
            if (node.val > largest.val) {
                prevLargest = prev;
                largest = node;
            }

            prev = node;
            node = node.next;
        }

        if (head == largest) {
            head = head.next;
        } else {
            prevLargest.next = largest.next;
        }
    }

    public void mergeTwoSortedLinkedList(LinkedList list) {
        var list2 = list.head;
        head = mergeTwoSortedLinkedList(head, list2);
    }

    private Node mergeTwoSortedLinkedList(Node l1, Node l2) {
        var previous = new Node(-1);
        var current = previous;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 == null ? l2 : l1;
        return previous.next;
    }

    public void deleteOnlyGivenNode() {
        deleteOnlyGivenNode(head.next.next.next);
    }

    private void deleteOnlyGivenNode(Node node) {
        if (node == null || node.next == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public boolean checkIfLinkedListPalindrome() {
        return checkIfLinkedListPalindrome(head);
    }

    private boolean checkIfLinkedListPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow, fast;
        slow = fast = head;

        Stack<Node> s = new Stack<Node>();
        s.push(slow);

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            s.push(slow);
        }

        if (fast.next == null) {
            s.pop();
        }

        Node secondHalf = slow.next;

        while (secondHalf != null) {
            if (s.pop().val != secondHalf.val) {
                return false;
            }
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void nthNodeFromEnd(int n) {
        nthNodeFromEnd(head, n);
    }

    private void nthNodeFromEnd(Node head, int n) {
        if (head == null)
            return;

        var slow = head;
        var fast = head;

        while (fast.next != null) {
            fast = fast.next;
            if (n-- <= 0) {
                slow = slow.next;
            }
        }

        assert slow.next != null;
        slow.next = slow.next.next;
    }

    public void display() {
        var current = head;
        System.out.println();
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
