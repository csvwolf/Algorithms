/**
 * Created by SkyAo on 2017/1/22.
 */
public class ResizingArrayStackOfStringOfStrings<Item> implements StackOfString<Item> {
    private Item[] s;
    private int N = 0;

    public ResizingArrayStackOfStringOfStrings() {
        s = (Item[]) new Object[1];
    }

    private void resize(int capacity) {
        Item[] copy = (Item []) new Object[capacity];
        System.arraycopy(s, 0, copy, 0, N);
        s = copy;
    }

    public void push(Item item) {
        if (N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    public Item pop() {
        Item item = s[--N];
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
