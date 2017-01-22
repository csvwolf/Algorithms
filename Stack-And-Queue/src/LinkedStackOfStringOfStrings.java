/**
 * 利用头结点操作
 *
 * Created by SkyAo on 2017/1/17.
 */
public class LinkedStackOfStringOfStrings<Item> implements StackOfString<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first = null;
    private int _size;

    public void push(Item item) {
        Node node = new Node();
        Node oldFirst = first;
        first = node;
        node.item = item;
        node.next = oldFirst;
        _size++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        _size--;

        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return _size;
    }

}
