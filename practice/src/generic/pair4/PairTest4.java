package generic.pair4;

import equals.Employee;
import equals.Manager;
import generic.pair1.PairGeneric;

/**
 * @version 1.01
 * @author Cay Horstamnn
 */

public class PairTest4 {
       public static void main(String... args) {
              Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
              Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
              PairGeneric<Manager> buddies = new PairGeneric<>(ceo, cfo);
              printBuddies(buddies);

              ceo.setBonus(1000000);
              cfo.setBonus( ceo.getBonus() / 2 );

              Manager[] managers = { ceo, cfo };

              PairGeneric<Employee> result = new PairGeneric<>();
              minmaxBonus(managers, result);
              System.out.println("first: " + result.getFirst().getName()
                       + ", second: " + result.getSecond() .getName());

              maxminBonus(managers, result);
              System.out.println("first: " + result.getFirst().getName()
                       + ", second: " + result.getSecond() .getName());
       }

       // ? extends ===> allow getter
       public static void printBuddies(PairGeneric<? extends Employee> p) {
              Employee first = p.getFirst();
              Employee second = p.getSecond();
              System.out.println(first.getName() + " and " + second.getName() + " are buddies. ");
       }

       // ? super ===> allow setter
       public static void minmaxBonus(Manager[] a, PairGeneric<? super Manager> result) {
              if (a.length == 0) return;
              Manager min = a[0];
              Manager max = a[0];
              for (int i = 1; i < a.length; i++) {
                     if (min.getBonus() > a[i].getBonus()) min = a[i];
                     if (max.getBonus() < a[i].getBonus()) max = a[i];
              }
              result.setFirst(min);
              result.setSecond(max);
       }

       public static void maxminBonus(Manager[] a, PairGeneric<? super Manager> result) {
              minmaxBonus(a, result);
              PairAlg.swapHelper(result); // OK --- swapHelper captures wildcard type
       }
}

class PairAlg {
       public static boolean hasNulls(PairGeneric<?> p) {
              return p.getFirst() == null || p.getSecond() == null;
       }

       public static void swap(PairGeneric<?> p) { swapHelper(p); }

       public static <T> void swapHelper(PairGeneric<T> p) {
              T t = p.getFirst();
              p.setFirst(p.getSecond());
              p.setSecond(t);
       }
}


