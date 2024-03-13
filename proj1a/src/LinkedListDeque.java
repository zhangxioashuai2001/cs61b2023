import java.util.List;
import java.util.ArrayList;
public class LinkedListDeque<T> implements Deque<T> {
    private int size;
    private Node sentinel;
    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    private class Node {
        private T item;
        private Node pre;
        private Node next;

        public Node(T t, Node p, Node n) {
            item = t;
            pre = p;
            next = n;
        }

        public Node() {
        }
    }
    @Override
    public void addFirst(T x) {
        Node newnode = new Node(x, sentinel, sentinel.next);
        sentinel.next.pre = newnode;
        sentinel.next = newnode;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node newnode = new Node(x, sentinel.pre, sentinel);
        sentinel.pre.next = newnode;
        sentinel.pre = newnode;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node temp = sentinel;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            returnList.add(temp.item);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node temp = sentinel.next;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return temp.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node temp = sentinel.pre;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return temp.item;
    }

    @Override
    public T get(int index) {
        if (index <= size & index > 0) {
            Node temp = sentinel;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.item;
        } else {
            return null;
        }
    }

    @Override
    public T getRecursive(int index) {
        if (index <= size & index > 0) {
            Node temp = sentinel;
            return (getRecursive(index, temp));
        } else {
            return null;
        }
    }
    public T getRecursive(int index, Node node) {
        index--;
        node = node.next;
        if (index == 0) {
            return node.item;
        }
        return getRecursive(index, node);
    }

    public static void main(String[] args) {
        Deque<Integer> lld = new LinkedListDeque<Integer>();
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);

    }
}
