/**
 * Created by SkyAo on 2017/1/22.
 */
public class ResizingArrayStackOfStrings implements Stack {
    private String[] s;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        System.arraycopy(s, 0, copy, 0, N);
        s = copy;
    }

    public void push(String item) {
        if (N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;

        if (N > 0 && N == s.length / 4) resize(s.length / 2);

        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
