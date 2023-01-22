package dataStructure.graphStructure;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph <V> extends AbstractGraph<V>{
    /** Construct an empty */
    public WeightedGraph() {
    }
    /** Construct a WeightedGraph from vertices and edges in list */
    public WeightedGraph(int[][] edges, int numberOfVertices) {
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++)
            vertices.add((V)(new Integer(i)));
        createWeightedGraph(vertices, edges);
    }
    /** Construct a WeightedGraph from vertices and edged in arrays */
    public WeightedGraph(V[] vertices, int[][] edges) {
        createWeightedGraph(java.util.Arrays.asList(vertices), edges);
    }
    /** Construct a WeightedGraph for vertices 0, 1, 2 and edge list */
    public WeightedGraph(List<V> vertices, List<WeightedEdge> edges) {
        createWeightedGraph(vertices, edges);
    }

    /** Create adjacency lists from edge arrays */
    private void createWeightedGraph(List<V> vertices, int[][] edges) {
        this.vertices = vertices;
        for (int i = 0; i < vertices.size(); i++)
// Create an edge list for each vertex
            neighbors.add(new ArrayList<Edge>());
        for (int i = 0; i < edges.length; i++)
            neighbors.get(edges[i][0]).add(
                    new WeightedEdge(edges[i][0], edges[i][1], edges[i][2]));
    }
    /** Create adjacency lists from edge lists */
    private void createWeightedGraph(List<V> vertices, List<WeightedEdge> edges) {
        this.vertices = vertices;
        for (int i = 0; i < vertices.size(); i++)
            neighbors.add(new ArrayList<Edge>()); // Create a list for vertices
        for (WeightedEdge edge: edges)
            neighbors.get(edge.u).add(edge); // Add an edge into the list
    }
    /** Construct a WeightedGraph from vertices 0, 1, and edge array */
    public WeightedGraph(List<WeightedEdge> edges, int numberOfVertices) {
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++)
            vertices.add((V)(new Integer(i)));
        createWeightedGraph(vertices, edges);
    }
    /** Return the weight on the edge (u, v) */
    public double getWeight(int u, int v) throws Exception {
        for (Edge edge : neighbors.get(u))
            if (edge.v == v)
                return ((WeightedEdge)edge).weight;
        throw new Exception("Edge does not exit");
    }
    /** Add edges to the weighted graph */
    public boolean addEdge(int u, int v, double weight) {
        return addEdge(new WeightedEdge(u, v, weight));
    }
    /** Display edges with weights */
    public void printWeightedEdges() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(getVertex(i) + " (" + i + "): ");
            for (Edge edge : neighbors.get(i))
                System.out.print("(" + edge.u +
                        ", " + edge.v + ", " + ((WeightedEdge)edge).weight + ") ");
            System.out.println();
        }
    }
// to continue later with minimum spanning tree and
// single-source shortest paths
public class MST extends Tree {
    private double totalWeight; // Total weight of all edges in the tree
    public MST(int root, int[] parent, List<Integer> searchOrder,
               double totalWeight) {
        super(root, parent, searchOrder);
        this.totalWeight = totalWeight;
    }
    public double getTotalWeight() {
        return totalWeight;
    }
}
    /** Get a minimum spanning tree rooted at vertex 0 */
    public MST getMinimumSpanningTree() {
        return getMinimumSpanningTree(0);
    }
    /** Get a minimum spanning tree rooted at a specified vertex */
    public MST getMinimumSpanningTree(int startingVertex) {
// cost[v] stores the cost by adding v to the tree
        double[] cost = new double[getSize()];
        for (int i = 0; i < cost.length; i++)
            cost[i] = Double.POSITIVE_INFINITY; // Initial cost
        cost[startingVertex] = 0; // Cost of source is 0
        int[] parent = new int[getSize()]; // Parent of a vertex
        parent[startingVertex] = -1; // startingVertex is the root
        double totalWeight = 0; // Total weight of the tree thus far
        List<Integer> T = new ArrayList<>();
        // Expand T
        while (T.size() < getSize()) {
// Find smallest cost v in V - T
            int u = -1; // Vertex to be determined
            double currentMinCost = Double.POSITIVE_INFINITY;
            for (int i = 0; i < getSize(); i++)
                if (!T.contains(i) && cost[i] < currentMinCost) {
                    currentMinCost = cost[i];
                    u = i;
                }
            T.add(u); // Add a new vertex to T
            totalWeight += cost[u]; // Add cost[u] to the tree
// Adjust cost[v] for v that is adjacent to u and v in V - T
            for (Edge e : neighbors.get(u))
                if (!T.contains(e.v) && cost[e.v] > ((WeightedEdge)e).weight) {
                    cost[e.v] = ((WeightedEdge)e).weight;
                    parent[e.v] = u;
                }
        } // End of while
        return new MST(startingVertex, parent, T, totalWeight);
    }
}
