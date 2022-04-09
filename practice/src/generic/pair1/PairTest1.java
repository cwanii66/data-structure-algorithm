package generic.pair1;

import java.io.Serializable;

/**
 * @version 1.01
 * @author Cay Horstman
 */

public class PairTest1 {
       public static void main(String[] args) {
              String[] words = { "Mary", "had", "a", "little", "lamb" };
              String middle = ArrayAlg.getMiddle("John", "Q.", "Public");
              PairGeneric<String> mm = ArrayAlg.minmax(words);
              System.out.println("min = " + mm.getFirst());
              System.out.println("max = " + mm.getSecond());
              System.out.println("middle = " + middle);
       }
}

class ArrayAlg {
       /**
        * Gets the minimum and maximum of an array of string.
        * @param a an array of string
        * @return a pair with the min and max value, or null if a is null or empty
        */
       public static PairGeneric<String> minmax(String[] a) {
              if (a == null || a.length == 0) return null;
              String min = a[0];
              String max = a[0];
              for (int i = 1; i < a.length; i++) {
                     if (min.compareTo(a[i]) > 0) min = a[i];
                     if (max.compareTo(a[i]) < 0) max = a[i];
              }
              return new PairGeneric<>(min, max);
       }
       public static <T> T getMiddle(T... a) {
              return a[a.length / 2];
       }
       // almost correct
       public static <T extends Comparable & Serializable> T min(T[] a) {
              if (a == null || a.length == 0) return null;
              T smallest = a[0];
              for (int i = 1; i < a.length; i++)
                     if (smallest.compareTo(a[i]) > 0) smallest = a[i];
              return smallest;
       }
}
