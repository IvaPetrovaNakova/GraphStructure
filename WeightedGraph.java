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
}
