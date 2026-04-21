package Trees_DSA;

import java.util.*;

public class bst_operations {

    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);
        return root;
    }

    public static Node deleteNode(Node root, int key) {
        if (root == null) return root;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private static int minValue(Node root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    public static void findRange(Node node, int low, int high, List<Integer> res) {
        if (node == null) return;
        if (low < node.val) findRange(node.left, low, high, res);
        if (low <= node.val && high >= node.val) res.add(node.val);
        if (high > node.val) findRange(node.right, low, high, res);
    }

    public static void main(String[] args) {
        int[] vals = {15, 10, 20, 8, 12, 17, 25};
        Node root = null;
        for (int v : vals) root = insert(root, v);

        root = deleteNode(root, 10);
        root = insert(root, 14);
        root = insert(root, 9);

        List<Integer> rangeRes = new ArrayList<>();
        findRange(root, 10, 20, rangeRes);
        System.out.println(rangeRes);
    }
}