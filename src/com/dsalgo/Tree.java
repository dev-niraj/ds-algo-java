package com.dsalgo;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

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

        if (isLeaf(root))
            return -1;

        return 1 + Math.max(
                height(root.left),
                height(root.right)
        );
    }

    public int min() {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;

        while (current != null) {
            last = current;
            current = current.left;
        }

        return last.val;
    }

    private int min(Node root) {
        if (isLeaf(root))
            return root.val;

        var left = min(root.left);
        var right = min(root.right);

        return Math.min(Math.min(left, right), root.val);
    }

    public boolean isEqual(Tree other) {
        return isEqual(root, other.root);
    }

    private boolean isEqual(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null) {
            return first.val == second.val &&
                    isEqual(first.left, second.left) &&
                    isEqual(first.right, second.right);
        }

        return false;
    }

    public void swapNode() {
        var temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.val < min || root.val > max)
            return false;

        return isBinarySearchTree(root.left, min, root.val - 1)
                && isBinarySearchTree(root.right, root.val + 1, max);
    }

    public ArrayList<Integer> getNodesAtKDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        getNodesAtKDistance(root, distance, list);
        return list;
    }

    private void getNodesAtKDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.val);
            return;
        }

        getNodesAtKDistance(root.left, distance - 1, list);
        getNodesAtKDistance(root.right, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++) {
            for(var value : getNodesAtKDistance(i)) {
                System.out.println(value);
            }
        }
    }

    public void sortedArrayToBST(int[] nums) {
        root = dfs(nums, 0, nums.length - 1);
    }

    private Node dfs(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}
