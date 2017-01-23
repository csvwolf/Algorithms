/**
 * Created by SkyAo on 2017/1/23.
 */
public class ResizingArrayQueue implements QueueOfString {
    private String[] queue = new String[1];
    private int head = 0;
    private int tail = 0;

    public void enqueue(String item) {
        if (tail == queue.length) resize(queue.length * 2);
        queue[tail++] = item;
    }

    public String dequeue() {
        String item = queue[head];
        queue[head++] = null;

        if (head < tail && tail - head == queue.length / 4) resize(queue.length / 2);
        return item;
    }

    public boolean isEmpty() {
        return tail - head == 0;
    }

    public int size() {
        return tail - head + 1;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        System.arraycopy(queue, head, copy, 0, tail - head);
        queue = copy;
        head = 0;
        tail = copy.length - 1;
    }
}
