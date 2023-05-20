public class QuickUnionFind {
    private final int[] parents;

    public QuickUnionFind(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be a positive integer");
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int index) {
        if (index < 0 || index >= parents.length) throw new IndexOutOfBoundsException();
        while (parents[index] != index) {
            index = parents[index];
        }
        return index;
    }

    public void union(int a, int b) {
        if (a < 0 || a >= parents.length || b < 0 || b >= parents.length) throw new IndexOutOfBoundsException();
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) parents[rootA] = rootB;
    }

    public int count() {
        int count = 0;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == i) count++;
        }
        return count;
    }
}