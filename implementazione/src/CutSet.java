import java.util.ArrayList;

public class CutSet {
//https://github.com/bunelr/sfm-min/tree/master/min-cut-pb
    Graph g;

    public CutSet(Graph g) {
        this.g = new Graph(g);
    }
    public CutSet() {
        g = new Graph();
    }
    private void addElement(Edge e) {
        g.addEdge(e);
    }
    private void removeElement(Edge e) {
        g.removeEdge(e);
    }

    public CutSet unionElem(Edge e) {       CutSet B = new CutSet(g);

        CutSet result = new CutSet();
        result.addElement(e);
        return result;
    }
    public CutSet setMinusElem(Edge e) {
        CutSet result = new CutSet();
        result.removeElement(e);
        return result;
    }
    public boolean equals(CutSet c) {
        return g.equals(c.g);
    }

    public static double evaluate(CutSet c) {
        //For each subset A ⊆ V , ve define f (A) to be the number of edges running from A to V \A.
        ArrayList<Edge> edges = new ArrayList<>(c.g.getEdges());
        int crossingEdges = 0;
        for (Edge edge : edges){
            //for each edge check if it's a cutting edge (arco di taglio)
            if (c.g.adj_list.containsKey(edge.src) && !c.g.adj_list.containsKey(edge.dest)) {
                crossingEdges++;
            }
        }
        return crossingEdges;
    }
}
