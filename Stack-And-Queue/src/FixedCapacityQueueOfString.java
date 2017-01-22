/**
 * Created by SkyAo on 2017/1/22.
 */
public class FixedCapacityQueueOfString implements QueueOfString {
    private String[] queue;
    private int head;
    private int tail;

    public FixedCapacityQueueOfString(int capacity) {
        queue = new String[capacity];
        head = 0;
        tail = 0;
    }

    public void enqueue(String item) {
        queue[tail++] = item;
    }

    public String dequeue() {
        String item = queue[head];
        queue[head++] = null;
        return item;

    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        return tail - head;
    }
}
