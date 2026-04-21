package Graphs_DSA;

import java.util.*;

public class city_road_network {

    static class Edge {
        String target;
        int weight;
        Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void addDirected(Map<String, List<Edge>> graph, String u, String v, int w) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(new Edge(v, w));
    }

    public static void addUndirected(Map<String, List<Edge>> graph, String u, String v, int w) {
        addDirected(graph, u, v, w);
        addDirected(graph, v, u, w);
    }

    public static Set<String> getReachable(Map<String, List<Edge>> graph, String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String curr = q.poll();
            for (Edge e : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(e.target)) {
                    visited.add(e.target);
                    q.add(e.target);
                }
            }
        }
        return visited;
    }

    public static int fewestTurnsBFS(Map<String, List<Edge>> graph, String start, String target) {
        if (start.equals(target)) return 0;
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> turns = new HashMap<>();
        q.add(start);
        turns.put(start, 0);

        while (!q.isEmpty()) {
            String curr = q.poll();
            int currentTurns = turns.get(curr);
            for (Edge e : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!turns.containsKey(e.target)) {
                    turns.put(e.target, currentTurns + 1);
                    q.add(e.target);
                    if (e.target.equals(target)) {
                        return currentTurns + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();
        addDirected(graph, "A", "B", 5);
        addUndirected(graph, "B", "C", 3);
        addUndirected(graph, "A", "D", 7);
        addDirected(graph, "D", "E", 2);
        addDirected(graph, "C", "E", 4);

        System.out.println(getReachable(graph, "A"));
        System.out.println(fewestTurnsBFS(graph, "A", "E"));
    }
}