package Graphs_DSA;

import java.util.*;

public class social_network_connection {

    public static void addEdge(Map<String, List<String>> graph, String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static List<String> getFriends(Map<String, List<String>> graph, String user) {
        return graph.getOrDefault(user, new ArrayList<>());
    }

    public static boolean areDirectlyConnected(Map<String, List<String>> graph, String u, String v) {
        return graph.containsKey(u) && graph.get(u).contains(v);
    }

    public static int getDegreeOfSeparation(Map<String, List<String>> graph, String start, String target) {
        if (start.equals(target)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distances = new HashMap<>();
        
        queue.add(start);
        distances.put(start, 0);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            int dist = distances.get(current);
            
            for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!distances.containsKey(neighbor)) {
                    distances.put(neighbor, dist + 1);
                    queue.add(neighbor);
                    if (neighbor.equals(target)) {
                        return dist + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        addEdge(graph, "Alice", "Bob");
        addEdge(graph, "Alice", "Charlie");
        addEdge(graph, "Bob", "David");
        addEdge(graph, "Charlie", "Eve");
        addEdge(graph, "David", "Eve");

        System.out.println(getFriends(graph, "Alice"));
        System.out.println(areDirectlyConnected(graph, "Bob", "Eve"));
        System.out.println(getDegreeOfSeparation(graph, "Alice", "Eve"));
    }
}