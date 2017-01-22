/**
 * Created by SkyAo on 2017/1/22.
 */
public class LinkedQueueOfStrings implements QueueOfString {
    private class Node {
        Node next;
        String item;
    }

    private Node first = null;
    private Node last = null;
    private int N = 0;

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;

        N++;
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }
}
