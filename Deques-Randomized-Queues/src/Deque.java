import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by SkyAo on 2017/1/23.
 */
public class Deque<Item> implements Iterable<Item> {
    private class Node {
        private Node next;
        private Node prev;
        private Item item;
    }

    private Node first;
    private Node last;
    private int n;

    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;
        first.next = oldFirst;

        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.prev = first;
        }
        n++;
    }

    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();

        Node newLast = new Node();
        newLast.item = item;
        newLast.next = null;
        newLast.prev = last;

        if (isEmpty()) {
            first = newLast;
        } else {
            last.next = newLast;
        }
        last = newLast;
        n++;

    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        Node oldFirst = first;
        Item item = oldFirst.item;

        first = oldFirst.next;
        n--;

        if (isEmpty()) {
            first = null;
            last = first;
        } else {
            first.prev = null;
        }

        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        Node oldLast = last;
        Item item = oldLast.item;

        last = oldLast.prev;
        n--;

        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            last.next = null;
        }


        return item;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
//        Deque<Integer> deque = new Deque<Integer>();
    }
}
