public class Approximations {

    public static void one_third_approximation(Graph g) {
        CutSet A = new CutSet();
        CutSet B = new CutSet(g);

        while (!A.equals(B)){

        }

    }

    public static void half_approximation(Graph g) {
        CutSet A = new CutSet();
        CutSet B = new CutSet(g);

        //todo: non ho capito la condizione di terminazione
    }
    public static void main(String[] args) {
       Graph g = new Graph("edges_test.txt");
       Graph.printGraph(g);
    }
}
