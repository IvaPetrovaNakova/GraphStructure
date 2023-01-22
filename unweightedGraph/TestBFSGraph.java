package dataStructure.graphStructure.unweightedGraph;

import dataStructure.graphStructure.AbstractGraph;
import dataStructure.graphStructure.Graph;

import java.util.List;

public class TestBFSGraph {
    public static void main(String[] args) {
        String[] vertices = {"Vidin", "Montana", "Vratza",
                "Pleven", "Veliko Tarnovo", "Ruse", "Shumen", "Dobrich",
                "Varna", "Sofia", "Pernik", "Bansko", "BLagoevgrad", "Pazardzik",
                "Plovdiv", "Haskovo", "Sliven", "Burgas"};
        int[][] edges = {
                {0, 1}, {0, 5}, {0, 12},
                {1, 0}, {1, 2}, {1, 3}, {1, 9},
                {2, 1}, {2, 3}, {2, 4}, {2, 9}, {2, 13},
                {3, 1}, {3, 2}, {3, 4}, {3, 5}, {3, 6}, {3, 9}, {3, 13}, {3, 14}, {3, 15},
                {4, 2}, {4, 3}, {4, 5}, {4, 6}, {4, 9}, {4, 14}, {4, 15}, {4, 16},
                {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7}, {5, 16},
                {6, 3}, {6, 4}, {6, 5}, {6, 7}, {6, 8}, {6, 14}, {6, 15}, {6, 16}, {6, 17},
                {7, 5}, {7, 6}, {7, 8},
                {8, 6}, {8, 7}, {8, 17},
                {9, 1}, {9, 2}, {9, 3}, {9, 4}, {9, 10}, {9, 11}, {9, 12}, {9, 13}, {9, 16},
                {10, 9}, {10, 11}, {10, 12},
                {11, 9}, {11, 10}, {11, 12}, {11, 13},
                {12, 0}, {12, 9}, {12, 10}, {12, 11}, {12, 13},
                {13, 2}, {13, 3}, {13, 9}, {13, 11}, {13, 12}, {13, 14},
                {14, 3}, {14, 4}, {14, 6}, {14, 13}, {14, 15}, {14, 16}, {14, 17},
                {15, 3}, {15, 4}, {15, 6}, {15, 14}, {15, 16}, {15, 17},
                {16, 4}, {16, 5}, {16, 6}, {16, 9}, {16, 14}, {16, 15}, {16, 17},
                {17, 6}, {17, 8}, {17, 14}, {17, 15}, {17, 16}
        };

        Graph<String> graph = new UnweightedGraph(vertices, edges);
        AbstractGraph<String>.Tree bfs = graph.bfs(graph.getIndex("Montana"));

        List<Integer> searchOrders = bfs.getSearchOrder();
        System.out.println(bfs.getNumberOfVerticesFound() +
                " vertices are searched in this order:");

        for (int i = 0; i < searchOrders.size(); i++)
            System.out.print(graph.getVertex(searchOrders.get(i)) + " ");

        for (int i = 0; i < searchOrders.size(); i++)
            if (bfs.getParent(i) != -1)
                System.out.println("the parent of " + graph.getVertex(i) +
                        " is " + graph.getVertex(bfs.getParent(i)));

    }
}
