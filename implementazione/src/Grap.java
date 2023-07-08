import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/***
 * Edge: Edge class for the adjacency list, public so classes outside Graph can access it if needed
 */
class Edge {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
}
// Graph class
class Graph {

    List<List<Node>> adj_list;

    /***
     * Node: Node class for the adjacency list, private so only Graph can access it
     */
    private static class Node {
        int value, weight;
        Node(int value, int weight)  {
            this.value = value;
            this.weight = weight;
        }
    }

    /***
     * Graph: Creates a graph from a text file
     * @param txtFile
     */
    public Graph(String txtFile){
        List<Edge> edges = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(txtFile));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                int src = Integer.parseInt(tokens[0]);
                int dest = Integer.parseInt(tokens[1]);
                int weight = Integer.parseInt(tokens[2]);
                edges.add(new Edge(src, dest, weight));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        adj_listPopulate(edges);
    }
    /***
     * Graph: Creates a graph from a list of edges
     * @param edges
     */
    public Graph(List<Edge> edges)
    {
        adj_listPopulate(edges);
    }

    /***
     * adj_listPopulate: Populates the adjacency list
     * @param edges
     */
    private void adj_listPopulate(List<Edge> edges){
        // adiacency list memory creation
        adj_list = new ArrayList<>();

        // adjacency list memory allocation
        for (int i = 0; i < edges.size(); i++)
            adj_list.add(i, new ArrayList<>());

        // add edges to the graph
        for (Edge e : edges)
        {
            // allocate new node in adjacency List from src to dest
            adj_list.get(e.src).add(new Node(e.dest, e.weight));
        }
    }

    /***
     * printGraph: Prints the graph, debugging purposes
     * @param graph
     */
    public static void printGraph(Graph graph)  {
        int src_vertex = 0;
        int list_size = graph.adj_list.size();

        System.out.println("The contents of the graph:");
        while (src_vertex < list_size) {
            //traverse through the adjacency list and print the edges
            for (Node edge : graph.adj_list.get(src_vertex)) {
                System.out.print("Vertex:" + src_vertex + " ==> " + edge.value +
                                " (" + edge.weight + ")\t");
            }

            System.out.println();
            src_vertex++;
        }
    }
}
