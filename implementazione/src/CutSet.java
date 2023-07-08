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

    public CutSet unionElem(Edge e) {
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
        //todo:capire qual'è la funzione che dato un set restituisce la valutazione (cioè la funione f)
        return 0;
    }
}
