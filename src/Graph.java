package src;

import java.util.*;


public class Graph {
    private Map<String, List<String>> adjList;

    public Graph() {
        this.adjList = new LinkedHashMap<>();
    }


    public boolean addVertex(String vertex) {
        vertex = vertex.trim();
        if (vertex.isEmpty()) return false;
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new ArrayList<>());
            System.out.println("Vertex '" + vertex + "' added.");
            return true;
        } else {
            System.out.println("Vertex '" + vertex + "' already exists.");
            return false;
        }
    }


    public boolean addEdge(String src, String dest, boolean isDirected) {
        src = src.trim();
        dest = dest.trim();

        if (src.isEmpty() || dest.isEmpty()) {
            System.out.println("Invalid vertex names.");
            return false;
        }


        if (!adjList.containsKey(src)) addVertex(src);
        if (!adjList.containsKey(dest)) addVertex(dest);


        List<String> neighborsSrc = adjList.get(src);
        if (!neighborsSrc.contains(dest)) {
            neighborsSrc.add(dest);
        }


        if (!isDirected) {
            List<String> neighborsDest = adjList.get(dest);
            if (!neighborsDest.contains(src)) {
                neighborsDest.add(src);
            }
        }

        System.out.println("Edge added between '" + src + "' and '" + dest + "' (" + (isDirected ? "Directed" : "Undirected") + ").");
        return true;
    }


    public void displayGraph() {
        if (adjList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("\n---------------- GRAPH ADJACENCY LIST ----------------");
        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("-------------------------------------------------------");
    }


    public PerformanceRecord bfsTraversal(String startVertex) {
        startVertex = startVertex.trim();
        if (!adjList.containsKey(startVertex)) {
            System.out.println("Error: Start vertex '" + startVertex + "' does not exist in graph.");
            return new PerformanceRecord("Graph Traversal", "BFS Traversal", 0, 0, "Vertex not found");
        }

        long startTime = System.nanoTime();
        int steps = 0;
        List<String> traversalPath = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            steps++;
            String current = queue.poll();
            traversalPath.add(current);

            List<String> neighbors = adjList.getOrDefault(current, Collections.emptyList());
            for (String neighbor : neighbors) {
                steps++;
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        String details = "Path: " + traversalPath;

        System.out.println("BFS Traversal starting from '" + startVertex + "': " + traversalPath);
        return new PerformanceRecord("Graph Traversal", "BFS Traversal", steps, duration, details);
    }


    public PerformanceRecord dfsTraversal(String startVertex) {
        startVertex = startVertex.trim();
        if (!adjList.containsKey(startVertex)) {
            System.out.println("Error: Start vertex '" + startVertex + "' does not exist in graph.");
            return new PerformanceRecord("Graph Traversal", "DFS Traversal", 0, 0, "Vertex not found");
        }

        long startTime = System.nanoTime();
        int[] steps = new int[]{0};
        List<String> traversalPath = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        dfsHelper(startVertex, visited, traversalPath, steps);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        String details = "Path: " + traversalPath;

        System.out.println("DFS Traversal starting from '" + startVertex + "': " + traversalPath);
        return new PerformanceRecord("Graph Traversal", "DFS Traversal", steps[0], duration, details);
    }

    private void dfsHelper(String current, Set<String> visited, List<String> traversalPath, int[] steps) {
        steps[0]++;
        visited.add(current);
        traversalPath.add(current);

        List<String> neighbors = adjList.getOrDefault(current, Collections.emptyList());
        for (String neighbor : neighbors) {
            steps[0]++;
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited, traversalPath, steps);
            }
        }
    }

    public Map<String, List<String>> getAdjList() {
        return adjList;
    }
}
