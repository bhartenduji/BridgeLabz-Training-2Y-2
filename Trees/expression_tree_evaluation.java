package Trees_DSA;

import java.util.*;

public class expression_tree_evaluation {

    static class Node {
        String val;
        Node left, right;
        Node(String val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void inorder(Node root) {
        if (root == null) return;
        if (root.left != null || root.right != null) System.out.print("(");
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
        if (root.left != null || root.right != null) System.out.print(")");
    }

    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static int evaluate(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return Integer.parseInt(root.val);
        
        int leftVal = evaluate(root.left);
        int rightVal = evaluate(root.right);

        switch (root.val) {
            case "+": return leftVal + rightVal;
            case "-": return leftVal - rightVal;
            case "*": return leftVal * rightVal;
            case "/": return leftVal / rightVal;
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node("*");
        root.left = new Node("+");
        root.left.left = new Node("3");
        root.left.right = new Node("5");
        
        root.right = new Node("-");
        root.right.left = new Node("8");
        root.right.right = new Node("2");

        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        System.out.println(evaluate(root));
    }
}