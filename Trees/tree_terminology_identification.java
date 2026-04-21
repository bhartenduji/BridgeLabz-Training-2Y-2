package Trees_DSA;

import java.util.*;

public class tree_terminology_identification {

    static class TreeNode {
        String name;
        List<TreeNode> children;
        TreeNode parent;

        TreeNode(String name) {
            this.name = name;
            this.children = new ArrayList<>();
            this.parent = null;
        }

        void addChild(TreeNode child) {
            child.parent = this;
            this.children.add(child);
        }
    }

    public static void findLeaves(TreeNode node, List<String> leaves) {
        if (node == null) return;
        if (node.children.isEmpty()) {
            leaves.add(node.name);
            return;
        }
        for (TreeNode child : node.children) {
            findLeaves(child, leaves);
        }
    }

    public static int getHeight(TreeNode node) {
        if (node == null) return -1;
        if (node.children.isEmpty()) return 0;
        int max = 0;
        for (TreeNode child : node.children) {
            max = Math.max(max, getHeight(child));
        }
        return max + 1;
    }

    public static int getDepth(TreeNode node) {
        int depth = 0;
        TreeNode curr = node;
        while (curr.parent != null) {
            depth++;
            curr = curr.parent;
        }
        return depth;
    }

    public static List<String> getAncestors(TreeNode node) {
        List<String> ancestors = new ArrayList<>();
        TreeNode curr = node.parent;
        while (curr != null) {
            ancestors.add(curr.name);
            curr = curr.parent;
        }
        return ancestors;
    }

    public static void main(String[] args) {
        TreeNode ceo = new TreeNode("CEO");
        TreeNode cto = new TreeNode("CTO");
        TreeNode cfo = new TreeNode("CFO");
        TreeNode devLead = new TreeNode("Dev Lead");
        TreeNode hr = new TreeNode("HR");
        TreeNode dev1 = new TreeNode("Dev1");
        TreeNode dev2 = new TreeNode("Dev2");

        ceo.addChild(cto);
        ceo.addChild(cfo);
        cto.addChild(devLead);
        cfo.addChild(hr);
        devLead.addChild(dev1);
        devLead.addChild(dev2);

        List<String> leaves = new ArrayList<>();
        findLeaves(ceo, leaves);
        System.out.println(leaves);
        
        System.out.println(getHeight(ceo));
        System.out.println(getDepth(devLead));
        System.out.println(getAncestors(dev1));
        System.out.println(cto.children.size());
    }
}