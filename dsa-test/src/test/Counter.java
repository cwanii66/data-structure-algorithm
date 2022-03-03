package test;

public class Counter {
       private final String name;
       private int count;
       public Counter(String id) {
              name = id;
       }
       public void increment() { count++; }
       public int tally() { return count ;}
       public String toString() { return count + " " + name; }

       public static void main(String[] args) {
              Counter heads = new Counter("heads");
              Counter tails = new Counter("tails");

              heads.increment();
              heads.increment();
              tails.increment();


       }
}
class Example {
       private int var; // instance variable
       private void method1() {
              int var; // part var
              // ...
       }
       private void method2() {
              // var ...
       }
}
