package Trees_DSA;

import java.util.*;

public class traversal_application {

    static class FileNode {
        String name;
        List<FileNode> children;
        int size;

        FileNode(String name, int size) {
            this.name = name;
            this.size = size;
            this.children = new ArrayList<>();
        }

        void add(FileNode child) {
            this.children.add(child);
        }
    }

    public static void preorder(FileNode node) {
        if (node == null) return;
        System.out.println(node.name);
        for (FileNode child : node.children) {
            preorder(child);
        }
    }

    public static void postorder(FileNode node) {
        if (node == null) return;
        for (FileNode child : node.children) {
            postorder(child);
        }
        System.out.println(node.name);
    }

    public static int calculateSize(FileNode node) {
        if (node == null) return 0;
        int total = node.size;
        for (FileNode child : node.children) {
            total += calculateSize(child);
        }
        return total;
    }

    public static void main(String[] args) {
        FileNode root = new FileNode("root", 0);
        FileNode home = new FileNode("home", 0);
        FileNode var = new FileNode("var", 0);
        FileNode user = new FileNode("user", 100);
        FileNode docs = new FileNode("docs", 500);
        FileNode log = new FileNode("log", 200);
        FileNode config = new FileNode("config", 50);

        root.add(home);
        root.add(var);
        home.add(user);
        home.add(docs);
        var.add(log);
        log.add(config);

        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        System.out.println(calculateSize(root));
    }
}