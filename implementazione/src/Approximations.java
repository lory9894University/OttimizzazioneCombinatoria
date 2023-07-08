
public class Approximations {

    public static void one_third_approximation(Graph g) {
        CutSet A = new CutSet();
        CutSet B = new CutSet(g);

        //For each element xi ∈ X
        for (Edge e : g.getEdges()){
            double ai = CutSet.evaluate(A.unionElem(e))-CutSet.evaluate(A);
            double bi = CutSet.evaluate(B.unionElem(e))-CutSet.evaluate(B);

            if (ai >= bi) {
                A = A.unionElem(e);
            } else {
                B = B.setMinusElem(e);
            }
        }

    }

    public static void half_approximation(Graph g) {
        CutSet A = new CutSet();
        CutSet B = new CutSet(g);

        //For each element xi ∈ X
         for (Edge e : g.getEdges()){
            double ai = CutSet.evaluate(A.unionElem(e))-CutSet.evaluate(A);
            double bi = CutSet.evaluate(B.unionElem(e))-CutSet.evaluate(B);

            ai = Math.max(ai, 0);
            bi = Math.max(bi, 0);
            double decisor = Math.random();

            if (decisor >= ai /(ai + bi)) { //todo: ma se faccio 0/0 + bi, java espolde?
                A = A.unionElem(e);
            } else {
                B = B.setMinusElem(e);
            }
        }


    }
    public static void main(String[] args) {
       Graph g = new Graph("edges_test.txt");
       Graph.printGraph(g);
    }
}
