import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;
/**
 * Created by SkyAo on 2017/1/23.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int first;
    private int last;
    private int N;

    public RandomizedQueue() {
        queue = (Item []) new Object[1];
        first = 0;
        last = 0;
        N = 0;  // 会导致数列中断
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int length) {
        Item[] newQueue = (Item []) new Object[length];
        int count = 0;
        for (int i = first; i < last; i++) {
            if (queue[i] != null) {
                newQueue[count++] = queue[i];
            }
        }

        queue = newQueue;

        last = N;
        first = 0;
    }

    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();

        if (last == queue.length) resize(queue.length * 2);
        queue[last++] = item;
        N++;
    }

    public Item dequeue() {
        Item item;
        if (isEmpty()) throw new NoSuchElementException();
        if (size() == queue.length / 4) resize(queue.length / 2);
        int choice = StdRandom.uniform(1, N + 1);
        int count = 0;
        int i = 0;
        int lastButOne = 0;
        while (count != choice) {
            if (queue[i] != null) {
                count++;
            }

            if (count == N - 1) {
                lastButOne = i;
            }

            i++;
        }

        if (choice == N) {
            last = lastButOne;
        }

        item = queue[i - 1];
        queue[i - 1] = null;
        N--;
        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();

        int choice = StdRandom.uniform(1, N + 1);
        int count = 0;
        int i = 0;

        while (count != choice) {
            if (queue[i] != null) {
                count++;
            }
            i++;
        }

        return queue[i - 1];
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int index;
        private Item[] copyQueue;

        public RandomizedQueueIterator() {
            copyQueue = (Item []) new Object[N];
            int count = 0;
            for (int i = first; i <= last; i++) {
                if (queue[i] != null) {
                    copyQueue[count++] = queue[i];
                }
            }

            index = 0;
            StdRandom.shuffle(copyQueue);
        }

        @Override
        public boolean hasNext() {
            if (!hasNext()) throw new NoSuchElementException();
            return index != N;
        }

        @Override
        public Item next() {
            return copyQueue[index++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        randomizedQueue.enqueue("Hello");
        randomizedQueue.enqueue("WOrld");
        randomizedQueue.enqueue("!");
        randomizedQueue.dequeue();

        System.out.println(randomizedQueue.size());
        Iterator iterator1 = randomizedQueue.iterator();
        Iterator iterator2 = randomizedQueue.iterator();

        while (iterator1.hasNext()) {
            System.out.print(iterator1.next());
        }
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next());
        }
    }
}
