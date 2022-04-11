package generic.pair1;

import java.util.function.Supplier;

public class PairGeneric<T> {
       private T first;
       private T second;

       public PairGeneric() { first = null; second = null; }
       public PairGeneric(T first, T second) {
              this.first = first;
              this.second = second;
       }

       public T getFirst() { return first; }
       public T getSecond() { return second; }

       public void setFirst(T newValue) { first = newValue; }
       public void setSecond(T newValue) { second = newValue; }

       public static <T> PairGeneric<T> makePair(Supplier<T> constr) {
              return new PairGeneric<>(constr.get(), constr.get());
       }
       public static <T> PairGeneric<T> makePair2(Class<T> cl) {
              try {
                     return new PairGeneric<>(cl.newInstance(), cl.newInstance());
              } catch (Exception ex) { return null; }
       }
}
