package queue;

/**
 * @param <T> the type of element held in the queue
 */
public interface Queue<T> {
    public abstract void offer(T elem);

    public abstract T poll();

    public abstract T peek();

    public abstract int size();

    public abstract boolean isEmpty();
}
