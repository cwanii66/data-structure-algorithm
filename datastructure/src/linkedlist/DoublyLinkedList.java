package linkedlist;

/**
 * A doubly linked list implementation
 */
public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    // we always need a traverser to traverse the Linked list
    private Node<T> head = null;
    private Node<T> tail = null;

    // internal node class to represent data
    public static class Node<T> {
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Empty this linked list, O(n)
    public void clear() {
        Node<T> trav = head;
        while(trav != null) {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    // return the size of this linked list
    public int size(){ return size; }

    // Is this linked list empty?
    public boolean isEmpty() { return size() == 0; }

    // Add an element to the tail of the linked list, O(1)
    public void add(T elem) { addLast(elem); }

    // Add a node to the tail of the linked list, O(1)
    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // Add an element to the beginning of this linked list, O(1)
    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    // Add an element at a specified index
    public void addAt(int index, T data) throws Exception {
        if (index < 0 || index > size) throw new Exception("Illegal Index!");
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }

        Node<T> temp = head;
    }


    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while(trav != null) {
            sb.append(trav.data);
            if (trav.next != null) sb.append(", ");
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
