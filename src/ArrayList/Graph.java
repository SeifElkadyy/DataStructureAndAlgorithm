package ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    ArrayList<Node> nodes; // List to store the nodes of the graph
    int[][] matrix; // 2D array (adjacency matrix) to represent edges

    Graph(int size) {
        nodes = new ArrayList<>(); // Initialize the list of nodes
        matrix = new int[size][size]; // Initialize the adjacency matrix with the given size
    }

    // Method to add a node to the graph
    public void addNode(Node node) {
        nodes.add(node);
    }

    // Method to add an edge from source to destination
    public void addEdge(int source, int destination) {
        matrix[source][destination] = 1; // Set the matrix value to 1 to indicate an edge
    }

    // Method to check if there is an edge from source to destination
    public boolean checkEdge(int source, int destination) {
        return matrix[source][destination] == 1; // Return true if there is an edge, otherwise false
    }

    // Method to print the graph's adjacency matrix
    public void printGraph() {
        // Print column headers
        System.out.print("  ");
        for (Node node : nodes) {
            System.out.print(node.data + " ");
        }
        System.out.println();

        // Print the adjacency matrix with row labels
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).data + " "); // Print row label
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " "); // Print matrix value
            }
            System.out.println();
        }
    }

    public void BFS(int source) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.offer(source);
        visited[source] = true;

        while (queue.size() != 0) {
            source = queue.poll();
            System.out.println(nodes.get(source).data + " = Visited");

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[source][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;

                }
            }
        }
    }
}