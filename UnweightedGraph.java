package dataStructure.graphStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UnweightedGraph <V> extends AbstractGraph<V> {

    /** Construct an empty graph */
    public UnweightedGraph() {
    }
    /** Construct a graph from vertices and edges stored in arrays */
    public UnweightedGraph(V[] vertices, int[][] edges) {
        super(vertices, edges);
    }
    /** Construct a graph from vertices and edges stored in List */
    public UnweightedGraph(List<V> vertices, List<Edge> edges) {
        super(vertices, edges);
    }
    /** Construct a graph for integer vertices 0, 1, 2 and edge list */
    public UnweightedGraph(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }
    /** Construct a graph from integer vertices 0, 1, and edge array */
    public UnweightedGraph(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    @Override
    public AbstractGraph<V>.Tree dfs(int v) {
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1; // Initialize parent[i] to -1
// Mark visited vertices (default false)
        boolean[] isVisited = new boolean[vertices.size()];
        List<Integer> searchOrder = new ArrayList();
// Recursively search
        dfs(v, parent, isVisited, searchOrder);
// Return the search tree
        return new Tree(v, parent, searchOrder);
    }

    /** Recursive method for DFS search */
    private void dfs(int u, int[] parent, boolean[] isVisited,
                     List<Integer> searchOrder) {
// Store the visited vertex
        searchOrder.add(u);
        isVisited[u] = true; // Vertex v visited
        for (Edge e : neighbors.get(u))
            if (!isVisited[e.v]) {
                parent[e.v] = u; // The parent of vertex e.v is u
                dfs(e.v, parent, isVisited, searchOrder); // Recursive search
            }
    }

    @Override
    public AbstractGraph<V>.Tree bfs(int v) {
            List<Integer> searchOrder = new ArrayList();
            int[] parent = new int[vertices.size()];
            for (int i = 0; i < parent.length; i++)
                parent[i] = -1; // Initialize parent[i] to -1
            LinkedList<Integer> queue = new LinkedList(); // list used as a queue
            queue.offer(v); // Enqueue v
            boolean[] isVisited = new boolean[vertices.size()];
            isVisited[v] = true; // Mark it visited
            while (!queue.isEmpty()) {
                int u = queue.poll(); // Dequeue to u
                searchOrder.add(u); // u searched
                for (Edge e: neighbors.get(u))
                    if (!isVisited[e.v]) {
                        queue.offer(e.v); // Enqueue v
                        parent[e.v] = u; // The parent of w is u
                        isVisited[e.v] = true; // Mark it visited
                    }
            }
            return new Tree(v, parent, searchOrder);
        }
    }



