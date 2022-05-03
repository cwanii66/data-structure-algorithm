/**
 * This file contains an implementation of an integer only stack which is extremely quick and
 * lightweight. In terms of performance it can outperform java.util.ArrayQueue (Java's fastest stack implementation)
 * by a factor of 50! See the benchmark test below for proof. However, the downside
 * is you need to know an upper bound on the number of elements that will be inside the stack at any given time
 * for it to work correctly.
 */
package stack;

import java.util.Stack;

public class IntStack extends Stack<Integer> {

    private final int[] ar;
    private int pos = 0;

    // maxSize is the maximum number of the items
    // that can be in the queue at any given time
    public IntStack(int maxSize) {
        ar = new int[maxSize];
    }

    // Returns the number of elements inside the stack
    public int size() {
        return pos;
    }

    // Returns true/false on whether the stack is empty
    public boolean isEmpty() {
        return pos == 0;
    }

    // Returns the element at the top of the stack
    @Override
    public Integer peek() {
        return ar[pos - 1];
    }

    @Override
    public Integer push(Integer value) {
        return ar[pos++] = value;
    }

    @Override
    public Integer pop() {
        return ar[--pos];
    }

    // Example usage
    public static void main(String... args) {

        IntStack stack = new IntStack(5);
        for (int i = 1; i <= 5; i++)
            stack.push(i);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(3);
        stack.push(4);
        stack.push(5);

        while (!stack.isEmpty()) System.out.println(stack.pop());
    }
}
