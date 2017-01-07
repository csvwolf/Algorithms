/**
 * Created by SkyAo on 2017/1/7.
 */
public class QuickFindUF implements UF {
    private int[] id;

    /**
     * 构造函数 初始化
     * @param N
     */
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * 是否连同
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == qid) id[i] = pid;
        }
    }
}
