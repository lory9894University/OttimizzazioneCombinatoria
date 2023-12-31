import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/***
 * Edge: Edge class for the adjacency list, public so classes outside Graph can access it if needed
 */
class Edge {
    int src, dest;
    double weight;

    Edge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    //debug
    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", dest=" + dest +
                ", weight=" + weight +
                '}';
    }
}

// Graph class
class Graph {

    HashMap<Integer, List<Node>> adj_list = new HashMap<>();

    /***
     * Graph: Creates a graph from a text file
     * @param txtFile
     */
    public Graph(String txtFile) {
        List<Edge> edges = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(txtFile));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                int src = Integer.parseInt(tokens[0]);
                int dest = Integer.parseInt(tokens[1]);
                double weight = Double.parseDouble(tokens[2]);
                edges.add(new Edge(src, dest, weight));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        addEdges(edges);
    }

    /***
     * Graph: Creates a graph from a list of edges
     * @param edges
     */
    public Graph(List<Edge> edges) {
        addEdges(edges);
    }

    /***
     * Graph: Creates an empty graph
     */
    public Graph() {
    }

    /***
     * Graph: duplicate an existing graph
     * @param g
     */
    public Graph(Graph g) {
        this.adj_list = new HashMap<>(g.adj_list);
        for (int src_vertex : g.adj_list.keySet()) {
            this.adj_list.put(src_vertex, new ArrayList<>(g.adj_list.get(src_vertex)));
        }
    }

    /***
     * printGraph: Prints the graph, debugging purposes
     * @param graph
     */
    public static void printGraph(Graph graph) {

        System.out.println("The adj list of the graph:");
        for (int src_vertex : graph.adj_list.keySet()) {
            if (graph.adj_list.get(src_vertex).size() != 0) {
                System.out.print("|" + src_vertex + "| => ");
                //traverse through the adjacency list and print the edges
                for (Node edge : graph.adj_list.get(src_vertex)) {
                    System.out.print("[" + edge.value + " (" + edge.weight + ")] -> ");
                }
                System.out.println("/");
            }
        }
    }

    /***
     * addEdge: Adds an edge to the graph
     */
    public void addEdge(Edge e) {
        // allocate new edge List from from source if not already present
        if (!adj_list.containsKey(e.src))
            adj_list.put(e.src, new ArrayList<>());
        // add dest to src's list
        adj_list.get(e.src).add(new Node(e.dest, e.weight));
    }

    /***
     * removeEdge: Removes an edge from the graph
     */
    public void removeEdge(Edge e) {
        // remove dest from src's list. get src's list using map, then remove the only node having same destination as given Edge e
        adj_list.get(e.src).removeIf(node -> node.value == e.dest);
    }

    /***
     * addEdges: Populates the adjacency list
     * @param edges
     */
    private void addEdges(List<Edge> edges) {
        // add edges to the graph
        for (Edge e : edges) {
            addEdge(e);
        }
    }

    /***
     * getEdges: Returns the edges of the graph
     * @return
     */
    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        for (int src_vertex : adj_list.keySet()) {
            for (Node edge : adj_list.get(src_vertex)) {
                edges.add(new Edge(src_vertex, edge.value, edge.weight));
            }
        }
        return edges;
    }

    /***
     * getVertices: Returns the vertices of the graph
     * @return
     */
    public Set<Integer> getVertices() {
        return adj_list.keySet();
    }

    /***
     * removeVertex: Removes a vertex from the graph
     * @param vertex
     */
    public void removeVertex(int vertex) {
        // remove vertex from graph
        adj_list.remove(vertex);
        // don't remove vertex from all other vertices' adjacency lists, ve still need to know which vertices are connected to vertex
    }

    /***
     * addVertex: Adds a vertex to the graph
     * @param vertex the vertex to be added
     * @param edges the edges of the vertex, as a list of Edges
     */
    public void addVertex(int vertex, List<Edge> edges) {
        // convert edges to list of Nodes
        List<Node> edges_list = edges.stream().map(e -> new Node(e.dest, e.weight)).collect(Collectors.toList());
        // add vertex to graph
        adj_list.put(vertex, edges_list);
    }

    /***
     * Node: Node class for the adjacency list, private so only Graph can access it
     */
    private static class Node {
        int value;
        double weight;

        Node(int value, double weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
