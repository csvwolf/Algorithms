import java.util.Iterator;

/**
 * Created by SkyAo on 2017/1/23.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int first;
    private int last;

    public RandomizedQueue() {
        queue = (Item []) new Object[1];
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return first == last;
    }

    public int size() {
        return last - first + 1;
    }

    private void resize(int length) {
        Item[] newQueue = (Item []) new Object[length];
        for (int i = first; i <= last; i++) {

        }

        last = size() - 1;
        first = 0;
    }

    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();

        if (last == queue.length) resize(queue.length * 2);
        queue[last++] = item;
    }

    public Item dequeue() {
        Item item = queue[first];
        if (size() == queue.length / 4) resize(queue.length / 2);
        queue[first++] = null;

        return item;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int index = first;
            @Override
            public boolean hasNext() {
                return index == last;
            }

            @Override
            public Item next() {
                return queue[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
    }
}
