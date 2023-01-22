package dataStructure.graphStructure;

import dataStructure.graphStructure.unweightedGraph.UnweightedGraph;

public class TestGraph {
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

        Graph<String> graph1 = new UnweightedGraph(vertices, edges);

        System.out.println("The number of vertices in graph1: "
                + graph1.getSize());

        System.out.println("The vertex with index 0 is "
                + graph1.getVertex(0));
//        System.out.println("The vertex with index 1 is "
//                + graph1.getVertex(1));
//        System.out.println("The vertex with index 2 is "
//                + graph1.getVertex(2));
//        System.out.println("The vertex with index 3 is "
//                + graph1.getVertex(3));
//        System.out.println("The vertex with index 4 is "
//                + graph1.getVertex(4));
//        System.out.println("The vertex with index 5 is "
//                + graph1.getVertex(5));
//        System.out.println("The vertex with index 6 is "
//                + graph1.getVertex(6));
//        System.out.println("The vertex with index 7 is "
//                + graph1.getVertex(7));
//        System.out.println("The vertex with index 8 is "
//                + graph1.getVertex(8));
//        System.out.println("The vertex with index 9 is "
//                + graph1.getVertex(9));
//        System.out.println("The vertex with index 10 is "
//                + graph1.getVertex(10));
//        System.out.println("The vertex with index 11 is "
//                + graph1.getVertex(11));
//        System.out.println("The vertex with index 12 is "
//                + graph1.getVertex(12));
//        System.out.println("The vertex with index 13 is "
//                + graph1.getVertex(13));
//        System.out.println("The vertex with index 14 is "
//                + graph1.getVertex(14));
//        System.out.println("The vertex with index 15 is "
//                + graph1.getVertex(15));
//        System.out.println("The vertex with index 16 is "
//                + graph1.getVertex(16));
//        System.out.println("The vertex with index 17 is "
//                + graph1.getVertex(17));


//        System.out.println("The index for Vidin is " +
//                graph1.getIndex("Vidin"));
//        System.out.println("The index for Montana is " +
//                graph1.getIndex("Montana"));
//        System.out.println("The index for Vratza is " +
//                graph1.getIndex("Vratza"));
//        System.out.println("The index for Pleven is " +
//                graph1.getIndex("Pleven"));
//        System.out.println("The index for Veliko Tarnovo is " +
//                graph1.getIndex("Veliko Tarnovo"));
//        System.out.println("The index for Ruse is " +
//                graph1.getIndex("Ruse"));
//        System.out.println("The index for Shumen is " +
//                graph1.getIndex("Shumen"));
//        System.out.println("The index for Dobrich is " +
//                graph1.getIndex("Dobrich"));
//        System.out.println("The index for Varna is " +
//                graph1.getIndex("Varna"));
//        System.out.println("The index for Sofia is " +
//                graph1.getIndex("Sofia"));
//        System.out.println("The index for Pernik is " +
//                graph1.getIndex("Pernik"));
//
//        System.out.println("The edges for graph1:");
//        graph1.printEdges();
//
//        String[] names = {"Vidin", "Montana", "Vratza", "Pleven", "Veliko Tarnovo", "Ruse", "Shumen", };
//        java.util.ArrayList<AbstractGraph.Edge> edgeList
//                = new java.util.ArrayList();
//        edgeList.add(new AbstractGraph.Edge(0, 2));
//        edgeList.add(new AbstractGraph.Edge(1, 2));
//        edgeList.add(new AbstractGraph.Edge(2, 4));
//        edgeList.add(new AbstractGraph.Edge(3, 4));
// //Create a graph with 5 vertices
//        Graph<String> graph2 = new UnweightedGraph(
//                java.util.Arrays.asList(names), edgeList);
//        System.out.println("\nThe number of vertices in graph2: "
//                + graph2.getSize());
//        System.out.println("The edges for graph2:");
//        graph2.printEdges();

    }
}
