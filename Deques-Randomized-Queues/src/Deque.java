import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by SkyAo on 2017/1/23.
 */
public class Deque<Item> implements Iterable<Item> {
    private class Node {
        Node next;
        Node prev;
        Item item;
    }

    private Node first;
    private Node last;
    private int N;

    public Deque() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void addFirst(Item item) {
        Node oldFirst = first;
        Node first = new Node();
        first.item = item;
        first.prev = null;
        first.next = oldFirst;
        N++;

        if (last == null) {
            last = first;
        }
    }

    public void addLast(Item item) {
        Node newLast = new Node();
        newLast.item = item;
        newLast.next = null;
        newLast.prev = last;
        N++;

        if (isEmpty()) {
            last = newLast;
            first = last;
        } else {
            last.next = newLast;
        }
    }

    public Item removeFirst() {
        Node oldFirst = first;
        Item item = oldFirst.item;

        if (oldFirst == null) throw new NoSuchElementException();

        first = oldFirst.next;
        if (last == oldFirst) last = first;
        oldFirst = null;
        N--;

        return item;
    }

    public Item removeLast() {
        Node oldLast = last;
        Item item = oldLast.item;

        if (last == null) throw new NoSuchElementException();

        last = oldLast.prev;
        if (first == oldLast) first = last;
        oldLast = null;
        N--;

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
                System.out.println(item);
                return item;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        deque.addFirst("World");
        deque.addFirst("Hello ");
//        deque.addLast("!");
//        deque.removeLast();
//        deque.addLast(".");

        Iterator iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
