import java.util.Objects;

public class CustomLinkedList<T> {
    private Node first;
    private Node last;
    private int size;

    public void add(T val) {
        if (Objects.isNull(first)) {
            first = new Node(val);
            last = first;
            size++;
            return;
        }
        Node newNode = new Node(val);
        newNode.previous = last;
        last.next = newNode;
        last = newNode;
        size++;
    }

    public T get(int index) {
        if (Objects.isNull(first)) {
            throw new IndexOutOfBoundsException("the list is empty");
        }

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("not valid index");
        }

        Node res = first;
        for (int i = 1; i <= index; i++) {
            res = res.next;
        }
        return res.value;
    }

    public void remove(int index) {
        if (Objects.isNull(first)) {
            throw new IndexOutOfBoundsException("the list is empty");
        }

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("not valid index");
        }

        Node removed = first;
        for (int i = 1; i <= index; i++) {
            removed = removed.next;
        }

        if (Objects.isNull(removed.previous)) {
            first = first.next;
            first.previous = null;
            size--;
            return;
        }

        if (Objects.isNull(removed.next)) {
            last = last.previous;
            last.next = null;
            size--;
            return;
        }
        removed.previous.next = removed.next;
        removed.next.previous = removed.previous;
        size--;
    }

    public boolean contains(T el) {
        Node temp = first;
        while (temp != null) {
            if (Objects.equals(temp.value, el)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    private class Node {
        private T value;
        private Node next;
        public Node previous;

        private Node () {

        }

        private Node(T value) {
            this.value = value;
        }

        private Node(T value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
