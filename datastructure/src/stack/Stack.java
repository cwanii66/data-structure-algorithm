package stack;

public interface Stack<T> {
    // return the number of elements in the stack
    public abstract int size();

    // return if the stack is empty
    public abstract boolean isEmpty();

    // push the element on the stack
    public abstract void push(T elem);

    // pop the element off the stack
    public abstract T pop();

    public abstract T peek();
}
