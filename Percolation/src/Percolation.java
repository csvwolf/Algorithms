/**
 * Created by SkyAo on 2017/1/9.
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF backwashChecked;
    private int gridSize;
    private final int startPoint;
    private final int endPoint;
    private boolean[][] sites;
    private int openSiteNumber;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        uf = new WeightedQuickUnionUF(n * n + 2);
        backwashChecked = new WeightedQuickUnionUF(n * n + 1);

        sites = new boolean[n][n];
        openSiteNumber = 0;

        startPoint = 0;
        endPoint = n * n + 1;
        gridSize = n;
    }

    private int getFlattenId(int row, int col) {
        if (row < 1 || row > gridSize || col < 1 || col > gridSize) throw new IndexOutOfBoundsException();
        return (row - 1) * gridSize + col;
    }

    public void open(int row, int col) {
        if (row < 1 || row > gridSize || col < 1 || col > gridSize) throw new IndexOutOfBoundsException();
        if (isOpen(row, col)) return;

        sites[row - 1][col - 1] = true;
        openSiteNumber++;

        if (row == 1) {
            uf.union(getFlattenId(row, col), startPoint);
            backwashChecked.union(getFlattenId(row, col), startPoint);
        }

        if (row == gridSize) {
            uf.union(getFlattenId(row, col), endPoint);
        }

        if (row > 1 && isOpen(row - 1, col)) {
            uf.union(getFlattenId(row - 1, col), getFlattenId(row, col));
            backwashChecked.union(getFlattenId(row - 1, col), getFlattenId(row, col));
        }

        if (row < gridSize && isOpen(row + 1, col)) {
            uf.union(getFlattenId(row + 1, col), getFlattenId(row, col));
            backwashChecked.union(getFlattenId(row + 1, col), getFlattenId(row, col));
        }

        if (col > 1 && isOpen(row, col - 1)) {
            uf.union(getFlattenId(row, col - 1), getFlattenId(row, col));
            backwashChecked.union(getFlattenId(row, col - 1), getFlattenId(row, col));
        }

        if (col < gridSize && isOpen(row, col + 1)) {
            uf.union(getFlattenId(row, col + 1), getFlattenId(row, col));
            backwashChecked.union(getFlattenId(row, col + 1), getFlattenId(row, col));
        }
    }

    public boolean isOpen(int row, int col) {
        if (row < 1 || row > gridSize || col < 1 || col > gridSize) throw new IndexOutOfBoundsException();
        return sites[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        if (row < 1 || row > gridSize || col < 1 || col > gridSize) throw new IndexOutOfBoundsException();
        return backwashChecked.connected(getFlattenId(row, col), startPoint);
    }

    public int numberOfOpenSites() {
        return openSiteNumber;
    }

    public boolean percolates() {
        return numberOfOpenSites() > 0 && uf.connected(startPoint, endPoint);
    }

    public static void main(String[] args) {
        int gridSize = StdIn.readInt();
        int row, col, temp;
        Percolation percolation = new Percolation(gridSize);
        while (!StdIn.isEmpty()) {
            row = StdIn.readInt();
            col = StdIn.readInt();
            percolation.open(row, col);
        }

        StdOut.print(percolation.percolates());
    }
}
