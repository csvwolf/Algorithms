/**
 * Created by SkyAo on 2017/1/7.
 */
public class Main {
    public static void main(String args[]) {
        WeightedQuickUnionUF quickFindUF = new WeightedQuickUnionUF(8);

        quickFindUF.union(0, 1);
        quickFindUF.union(2, 3);
        quickFindUF.union(4, 5);
        quickFindUF.union(2, 5);
        quickFindUF.show();
        System.out.println(quickFindUF.connected(3, 4));
    }
}
