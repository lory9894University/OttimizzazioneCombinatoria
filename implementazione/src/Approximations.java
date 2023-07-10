public class Approximations {

    public static void one_third_approximation(Graph g) {
        CutSet A = new CutSet();
        CutSet B = new CutSet(g);

        //For each element xi ∈ X
        for (Edge e : g.getEdges()) {
            double ai = CutSet.evaluate(A.unionElem(e)) - CutSet.evaluate(A);
            double bi = CutSet.evaluate(B.setMinusElem(e)) - CutSet.evaluate(B);

            if (ai >= bi) {
                A = A.unionElem(e);
            } else {
                B = B.setMinusElem(e);
            }
        }
        Graph.printGraph(A.g);
        Graph.printGraph(B.g);
    }

    public static void half_approximation(Graph g) {
        CutSet A = new CutSet();
        CutSet B = new CutSet(g);

        //For each element xi ∈ X
        for (Edge e : g.getEdges()) {
            double ai = CutSet.evaluate(A.unionElem(e)) - CutSet.evaluate(A);
            double bi = CutSet.evaluate(B.setMinusElem(e)) - CutSet.evaluate(B);

            ai = Math.max(ai, 0);
            bi = Math.max(bi, 0);
            double decisor = Math.random();

            if (decisor >= ai / (ai + bi)) {
                B = B.setMinusElem(e);
            } else {
                A = A.unionElem(e);
            }
        }
        Graph.printGraph(A.g);
        Graph.printGraph(B.g);

    }

    public static void main(String[] args) {
        Graph g = new Graph("edges_test.txt");
        one_third_approximation(g);
        half_approximation(g);
    }
}
