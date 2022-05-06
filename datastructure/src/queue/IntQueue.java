package queue;

/**
 * This file contains an implementation of an integer only queue which is extremely
 * lightweight. In terms of performance it can outperform java.util.ArrayQueue by the
 * factor of 40+! See the benchmark test below for proof.
 * However, the downside is you need to know an upper bound on the number of elements
 * that will be inside the queue at any given time for this queue to work.
 */

public class IntQueue implements Queue<Integer> {

    private int[] data;
    private int front, end;
    private int size;

    // maxSize is the maximum number of items
    // that can be in the queue at any given time
    public IntQueue(int maxSize) {
        front = end = size = 0;
        data = new int[maxSize];
    }

    @Override
    public void offer(Integer elem) {
        if (isFull()) throw new RuntimeException("Queue is too small");
        data[end++] = elem;
        size++;
        end = end % data.length;
    }

    @Override
    public Integer poll() {
        if (size == 0) throw new RuntimeException("Queue is Empty");
        size--;
        front = front % data.length;
        return data[front++];
    }

    @Override
    public Integer peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        front = front % data.length;
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    // Example usage
    public static void main(String... args) {
        IntQueue q = new IntQueue(5);

        for (int i = 1; i <= 5; i++) q.offer(i);

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

        System.out.println(q.isEmpty());

        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

        System.out.println(q.isEmpty());
    }
}
