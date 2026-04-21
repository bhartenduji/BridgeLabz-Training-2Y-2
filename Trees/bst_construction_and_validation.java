package Trees_DSA;

import java.util.*;

public class bst_construction_and_validation {

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

    public static void inorder(Node root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static boolean isValidBST(Node root) {
        return validate(root, null, null);
    }

    private static boolean validate(Node node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        int[] vals = {50, 30, 70, 20, 40, 60, 80, 10, 25};
        Node root = null;
        for (int v : vals) {
            root = insert(root, v);
        }

        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        System.out.println(res);
        System.out.println(isValidBST(root));
    }
}