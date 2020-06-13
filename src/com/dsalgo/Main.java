package com.dsalgo;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        list.deleteOnlyGivenNode();

        list.display();
    }
}