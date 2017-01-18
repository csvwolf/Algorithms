/**
 * Created by SkyAo on 2017/1/22.
 */
public class FixedCapacityStackOfString implements Stack {
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfString(int capacity) {
        s = new String[capacity];
    }

    // 最简陋的实现，没有考虑超过容量的情况
    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
