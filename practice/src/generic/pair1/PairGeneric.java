package generic.pair1;

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
}
