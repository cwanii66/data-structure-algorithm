package collection;

import java.util.Collection;
import java.util.Iterator;

public class test {
       public static void main(String... args) {

       }
       public static <E> boolean contains(Collection<E> c, Object obj) {
              for (E element : c)
                     if (element.equals(obj)) return true;
              return false;
       }
}

abstract class AbstractCollection<E> implements Collection<E> {

       @Override
       public abstract Iterator<E> iterator();

       public boolean contains(Object obj) {
              for (E element : this) { // calls iterator()
                     if (element.equals(obj)) return true;
              }
              return false;
       }
}





//interface Queue<E> {
//       void add(E element);
//       E remove();
//       int size();
//}
//
//class CircularArrayQueue<E> implements Queue<E> {
//       private int head;
//       private int tail;
//
//       CircularArrayQueue(int capacity) { /*. . .*/ }
//       public void add(E element) { /*. . .*/ }
//       public E remove() { /*. . .*/ }
//       public int size() {/*. . .*/}
//       private E[] elements;
//}
