package lambda;

import java.util.Comparator;

/**
 * this class demonstrates how to handle lambda expression
 * @author Chris Wong
 * @version 1.0
 */

public class lambdaDeal {
       public static void main(String[] args) {
              lambdaDeal.repeat(10, i -> System.out.println("Countdown: " + (9 - i)));
       }
//       public static void repeat(int n, Runnable action) {
//              for (int i = 0; i < n; i++) action.run();
//       }
       public static void repeat(int n, IntConsumer action) {
              for (int i = 0; i < n; i++) action.accept(i);
       }
}

@FunctionalInterface
interface IntConsumer {
       void accept(int value);
}
