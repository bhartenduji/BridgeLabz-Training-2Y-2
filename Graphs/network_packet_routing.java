package Graphs_DSA;

import java.util.*;

public class network_packet_routing {

    public static boolean isConnected(Map<String, List<String>> graph, Set<String> nodes) {
        if (nodes.isEmpty()) return true;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String start = nodes.iterator().next();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String curr = q.poll();
            for (String neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
        return visited.size() == nodes.size();
    }

    public static int getMinHops(Map<String, List<String>> graph, String start, String target) {
        if (start.equals(target)) return 0;
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> hops = new HashMap<>();
        q.add(start);
        hops.put(start, 0);

        while (!q.isEmpty()) {
            String curr = q.poll();
            int currHops = hops.get(curr);
            for (String neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!hops.containsKey(neighbor)) {
                    hops.put(neighbor, currHops + 1);
                    q.add(neighbor);
                    if (neighbor.equals(target)) return currHops + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Set<String> routers = new HashSet<>(Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6"));
        Map<String, List<String>> listGraph = new HashMap<>();
        
        String[][] edges = {
            {"R1", "R2"}, {"R1", "R3"}, {"R2", "R4"}, 
            {"R3", "R4"}, {"R4", "R5"}, {"R5", "R6"}
        };

        for (String[] e : edges) {
            listGraph.putIfAbsent(e[0], new ArrayList<>());
            listGraph.putIfAbsent(e[1], new ArrayList<>());
            listGraph.get(e[0]).add(e[1]);
            listGraph.get(e[1]).add(e[0]);
        }

        System.out.println(isConnected(listGraph, routers));
        System.out.println(getMinHops(listGraph, "R1", "R6"));
        
        listGraph.get("R4").remove("R5");
        listGraph.get("R5").remove("R4");
        
        System.out.println(getMinHops(listGraph, "R1", "R6"));
    }
}