public class CutSet {
//https://github.com/bunelr/sfm-min/tree/master/min-cut-pb
    Graph g;

    public CutSet(Graph g) {
        this.g = new Graph(g);
    }
    public CutSet() {
        g = new Graph();
    }
    public void addElement(Edge e) {
        g.addEdge(e);
    }
    public void removeElement(Edge e) {
        g.removeEdge(e);
    }

    public boolean equals(CutSet c) {
        return g.equals(c.g);
    }
    public float evaluate() {
        //todo:capire qual'è la funzione che dato un set restituisce la valutazione (cioè la funione f)
        return 0;
    }
}
