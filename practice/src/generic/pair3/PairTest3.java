package generic.pair3;

import generic.pair1.PairGeneric;

import java.io.File;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

public class PairTest3 {
       public static void main(String... args) {
              PairGeneric<String> p = PairGeneric.makePair(String :: new); // provide a functional interface
              PairGeneric<String> p2 = PairGeneric.makePair2(String.class); // Class 类本身就是泛型
       }
       @SafeVarargs
       static <E> E[] array(E... array) { return array; } // 使用@safeVarargs 标注来消除创建泛型数组有关的限制
       // 但是需要时刻注意类型擦除带来的异常状况
}

class DateInterval extends PairGeneric<LocalDate> {

}

/*
如果数组仅仅作为一个类的私有实例域，
就可以将这个数组声明为 Object[]，
并且在获取元素时进行类型转换.
 */
// an example of ArrayList class
class ArrayList<E> {
       private Object[] elements;
       @SuppressWarnings("unchecked") public E get(int n) { return (E) elements[n]; }
       public void set(int n, E e) { elements[n] = e; } // no cast needed
}

// Generic class may not extend 'java.lang.Throwable'
// class Problem<T> extends Exception {}

class Problem {
       // 在异常规范中使用类型变量是允许的。以下方法是合法的：
       public static <T extends Throwable> void doWork(T t) throws T { // OK
              try {
                     // do work
              } catch (Throwable realCause) {
                     t.initCause(realCause);
                     throw t;
              }
       }
}

/*
用户可以覆盖 body 方法来提供一个具体的动作。
调用 toThread 时，
会得到 Thread 类的一个对象，
它的 run 方法不会介意受查异常。
 */
/*
try
{
do work
}
catch (Throwable t)
{
Block.<RuntimeException>throwAs(t) ;
}
 */
abstract class Block {
       public abstract void body() throws Exception;

       public Thread toThread() {
              return new Thread(() -> {
                     try {
                            body();
                     } catch(Throwable t) {
                            Block.<RuntimeException>throwAs(t);
                     }
              });
       }
       @SuppressWarnings("unchecked")
       public static <T extends Throwable> void throwAs(Throwable e) throws T {
              throw (T) e;
       }
}
// 运行一个thread， 抛出一个受查异常
class ExceptionBlock {
       public static void main(String... args) {
              new Block() { // 实现Block抽象类的新对象 （匿名内部类语法）
                     public void body() throws Exception {
                            Scanner in = new Scanner(new File("ququx"), "UTF-8");
                            while (in.hasNext()) {
                                   System.out.println(in.next());
                            }
                     }
              }
              .toThread().start();
       }
}
