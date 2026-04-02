package Recursion_and_Backtracking;

import java.util.*;

public class file_size_calculator {

    static abstract class FileSystemEntity {
        String name;
        public FileSystemEntity(String name) { this.name = name; }
        abstract int getSize(Set<String> visited);
    }

    static class File extends FileSystemEntity {
        int size;
        public File(String name, int size) {
            super(name);
            this.size = size;
        }
        @Override
        int getSize(Set<String> visited) {
            return size;
        }
    }

    static class Directory extends FileSystemEntity {
        List<FileSystemEntity> contents = new ArrayList<>();
        public Directory(String name) { super(name); }
        
        public void add(FileSystemEntity entity) {
            contents.add(entity);
        }

        @Override
        int getSize(Set<String> visited) {
            if (visited.contains(this.name)) return 0;
            visited.add(this.name);

            int totalSize = 0;
            for (FileSystemEntity entity : contents) {
                totalSize += entity.getSize(visited);
            }
            return totalSize;
        }
    }

    public static void main(String[] args) {
        Directory project = new Directory("project");
        Directory src = new Directory("src");
        Directory docs = new Directory("docs");
        Directory guides = new Directory("guides");

        src.add(new File("main.java", 100));
        src.add(new File("utils.java", 50));
        guides.add(new File("setup.pdf", 200));
        guides.add(new File("config.xml", 20));
        docs.add(new File("readme.txt", 10));
        docs.add(guides);

        project.add(src);
        project.add(docs);

        System.out.println("Total Project Size: " + project.getSize(new HashSet<>()) + " KB");
    }
}