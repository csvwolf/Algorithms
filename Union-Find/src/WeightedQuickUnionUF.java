import java.util.Arrays;

/**
 * Created by SkyAo on 2017/1/7.
 */
public class WeightedQuickUnionUF implements UF {
    private int[] id;
    private int[] size;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];  // 路径压缩, 在寻找根节点的同时移动至根节点
            i = id[i];
        }
        return i;
    }

    public void show() {
        System.out.println(Arrays.toString(id));
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int qid = root(q);
        int pid = root(p);

        if (pid == qid) return;

        if (size[qid] > size[pid]) {
            id[pid] = qid;
            size[qid] += size[pid];
        } else {
            id[qid] = pid;
            size[pid] += size[qid];
        }
    }
}
