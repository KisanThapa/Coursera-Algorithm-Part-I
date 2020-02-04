public class QuickUnion {

    public static void main(String[] args) {

        QUnion qu = new QUnion(5);

        qu.printData();

        qu.union(2, 3);
        qu.printData();
        System.out.println("isConnected(3, 2): " + qu.isConnected(3, 2));

        qu.union(0, 1);
        qu.printData();
        System.out.println("isConnected(0, 1): " + qu.isConnected(0, 1));

    }

    public static class QUnion {

        int[] id;

        public QUnion(int size) {

            id = new int[size];
            for (int i = 0; i < size; i++) {
                id[i] = i;
            }

        }

        public boolean isConnected(int p, int q) {
            return root(p) == root(q);

        }

        public int root(int p) {
            while (p != id[p])
                p = id[p];
            return p;
        }

        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);

            id[i] = j;
        }

        public void printData() {
            System.out.print("index: ");
            for (int i = 0; i < id.length; i++)
                System.out.print(i + "  ");
            System.out.println();
            System.out.print("id   : ");
            for (int value : id) System.out.print(value + "  ");
            System.out.println();
            System.out.println("--------------------------------------");

        }

    }

}
