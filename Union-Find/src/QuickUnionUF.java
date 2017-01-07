import java.util.Arrays;

/**
 * Created by SkyAo on 2017/1/7.
 */
public class QuickUnionUF implements UF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (id[i] != i) i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void show() {
        System.out.println(Arrays.toString(id));
    }

    /**
     * QuickUnion 把 一个的根连接到另一棵树上
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int qid = root(q);
        int pid = root(p);

        id[qid] = pid;
    }
}
