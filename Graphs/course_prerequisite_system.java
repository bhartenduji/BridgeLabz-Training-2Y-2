package Graphs_DSA;

import java.util.*;

public class course_prerequisite_system {

    public static boolean hasCycle(Map<String, List<String>> graph, String node, Set<String> visited, Set<String> recStack) {
        if (recStack.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        recStack.add(node);

        for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (hasCycle(graph, neighbor, visited, recStack)) {
                return true;
            }
        }
        recStack.remove(node);
        return false;
    }

    public static List<String> topologicalSort(Map<String, List<String>> graph, Set<String> allCourses) {
        Map<String, Integer> inDegree = new HashMap<>();
        for (String course : allCourses) inDegree.put(course, 0);
        
        for (String u : graph.keySet()) {
            for (String v : graph.get(u)) {
                inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
            }
        }

        Queue<String> q = new LinkedList<>();
        for (String course : allCourses) {
            if (inDegree.get(course) == 0) q.add(course);
        }

        List<String> order = new ArrayList<>();
        while (!q.isEmpty()) {
            String u = q.poll();
            order.add(u);
            for (String v : graph.getOrDefault(u, new ArrayList<>())) {
                inDegree.put(v, inDegree.get(v) - 1);
                if (inDegree.get(v) == 0) q.add(v);
            }
        }
        return order.size() == allCourses.size() ? order : new ArrayList<>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> allCourses = new HashSet<>(Arrays.asList("CS101", "CS102", "CS201", "CS202", "MATH101"));
        
        graph.putIfAbsent("CS101", new ArrayList<>());
        graph.get("CS101").add("CS102");
        graph.get("CS101").add("CS201");
        
        graph.putIfAbsent("CS102", new ArrayList<>());
        graph.get("CS102").add("CS202");
        
        graph.putIfAbsent("MATH101", new ArrayList<>());
        graph.get("MATH101").add("CS201");

        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();
        boolean cycle = false;
        for (String course : allCourses) {
            if (hasCycle(graph, course, visited, recStack)) {
                cycle = true;
                break;
            }
        }
        
        System.out.println(cycle);
        System.out.println(topologicalSort(graph, allCourses));
    }
}