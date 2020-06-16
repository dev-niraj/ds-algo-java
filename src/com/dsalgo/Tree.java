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

    public boolean find(int val) {
        if (root == null)
            return false;

        var current = root;

        while (current != null) {
            if (val < current.val) {
                current = current.left;
            } else if (val > current.val) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.left);
        System.out.print(root.val + " ");
        traverseInOrder(root.right);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        return 1 + Math.max(
                height(root.left),
                height(root.right)
        );
    }

}
