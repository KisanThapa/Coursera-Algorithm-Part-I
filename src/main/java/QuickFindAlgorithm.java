/**
 * This algorithm can be used to solve dynamic connectivity problem.
 * This algorithm is kept very simple. It supports two operations,
 * <p>
 * isConnected(a, b): To check if a and b are in the same component
 * union(a, b): If two elements are not in the same component then
 * this operation merge these components(merge(component of a, component of b))
 */

public class QuickFindAlgorithm {

    public static void main(String[] args) {

        QuickFind qf = new QuickFind(10);

        qf.printArray();

        qf.union(5, 6);
        qf.printArray();

        qf.union(1, 7);
        qf.printArray();

        qf.union(3, 7);
        qf.printArray();

        qf.union(5, 0);
        qf.printArray();

        System.out.println(qf.isConnected(8, 9));
        System.out.println(qf.isConnected(0, 6));

    }

    static class QuickFind {
        public int[] id;

        public QuickFind(int size) {
            id = new int[size];

            for (int i = 0; i < size; i++) {
                id[i] = i;
            }
        }

        public boolean isConnected(int p, int q) {
            return (id[p] == id[q]);
        }

        public void union(int p, int q) {
            int pid = id[p];
            int qid = id[q];

            for (int i = 0; i < id.length; i++) {
                if (id[i] == pid)
                    id[i] = qid;
            }
        }

        public void printArray() {
            for (int value : id) {
                System.out.print(value + "  ");
            }
            System.out.println();
        }
    }
}
