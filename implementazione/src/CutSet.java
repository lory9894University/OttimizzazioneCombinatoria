import java.util.ArrayList;

public class CutSet {
    //https://github.com/bunelr/sfm-min/tree/master/min-cut-pb
    Graph g;
    Graph original; //this is the original graph, used to add elements to the cutset


    /**
     * CutSet: Creates a cutset from a graph, the cutset is initialized with the same vertices as the graph
     *
     * @param g        the graph
     * @param original the original graph
     */
    public CutSet(Graph g, Graph original) {
        this.g = new Graph(g);
        this.original = new Graph(original);
    }

    /**
     * CutSet: Creates an empty CutSet
     *
     * @param original the original graph
     */

    public CutSet(Graph original) {
        this.original = new Graph(original);
        g = new Graph();
    }

    public static double evaluate(CutSet c) {
        //For each subset A ⊆ V , ve define f (A) to be the number of edges running from A to V \A.
        ArrayList<Edge> edges = new ArrayList<>(c.g.getEdges());
        int crossingEdgesValue = 0;
        for (Edge edge : edges) {
            //for each edge check if it's a cutting edge (arco di taglio)
            if (c.g.adj_list.containsKey(edge.src) && !c.g.adj_list.containsKey(edge.dest)) {
                crossingEdgesValue += edge.weight;
            }
        }
        return crossingEdgesValue;

        //in ogni caso questo definisce un max cut, non un min cut
    }

    private void addElement(int vertex, ArrayList<Edge> edges) {
        g.addVertex(vertex, edges);
    }

    private void removeElement(int vertex) {
        g.removeVertex(vertex);
    }

    public CutSet unionElem(int vertex) {
        CutSet result = new CutSet(g, original);
        ArrayList<Edge> edges = new ArrayList<>();
        for (Edge edge : original.getEdges()) {
            if (edge.src == vertex) {
                edges.add(edge);
            }
        }
        result.addElement(vertex, edges);
        return result;
    }

    public CutSet setMinusElem(int vertex) {
        CutSet result = new CutSet(g, original);
        result.removeElement(vertex);
        return result;
    }

    public boolean equals(CutSet c) {
        return g.equals(c.g);
    }
}
