package com.dsalgo;

public class Tree {
    private class Node {
        private int val;
        private Node left;
        private Node right;

        public Node (int val) {
            this.val = val;
        }

        @Override
        public String toString () {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    private Node root;

    public void insert(int val) {
        var node = new Node(val);

        if (root == null) {
            root = new Node(val);
            return;
        }

        var current = root;
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
    }
}
