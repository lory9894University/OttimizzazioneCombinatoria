import java.util.ArrayList;

public class Approximations {

    public static void one_third_approximation(Graph g) {
        CutSet A = new CutSet(g);
        CutSet B = new CutSet(g, g);

        //For each element xi ∈ X
        for (int v : g.getVertices()) {
            double ai = CutSet.evaluate(A.unionElem(v)) - CutSet.evaluate(A);
            double bi = CutSet.evaluate(B.setMinusElem(v)) - CutSet.evaluate(B);

            if (ai >= bi) {
                A = A.unionElem(v);
            } else {
                B = B.setMinusElem(v);
            }
        }
        Graph.printGraph(A.g);
        Graph.printGraph(B.g);
        System.out.println("Cut value (A): " + CutSet.evaluate(A) + "\nCut value (B): " + CutSet.evaluate(B));
    }

    public static void half_approximation(Graph g) {
        CutSet A = new CutSet(g);
        CutSet B = new CutSet(g, g);

        //For each element xi ∈ X
        for (int v : g.getVertices()) {
            double ai = CutSet.evaluate(A.unionElem(v)) - CutSet.evaluate(A);
            double bi = CutSet.evaluate(B.setMinusElem(v)) - CutSet.evaluate(B);

            ai = Math.max(ai, 0);
            bi = Math.max(bi, 0);
            double decisor = Math.random();

            if (decisor >= ai / (ai + bi)) {
                B = B.setMinusElem(v);
            } else {
                A = A.unionElem(v);
            }
        }
        Graph.printGraph(A.g);
        Graph.printGraph(B.g);

        System.out.println("Cut value (A): " + CutSet.evaluate(A) + "\nCut value (B): " + CutSet.evaluate(B));
    }

    public static void main(String[] args) {
        Graph g = new Graph("test4.txt");
        System.out.println("----------One third approximation----------");
        one_third_approximation(g);
        System.out.println("----------Half approximation----------");
        half_approximation(g);
    }
}
