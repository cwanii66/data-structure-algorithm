package lambda;

import javax.swing.Timer;
import java.awt.*;
//import java.util.function.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class functional implements Predicate<String>{
       public static void main(String[] args) {
              String[] words = new String[12];
              // functional interface
              Arrays.sort(words, String :: compareToIgnoreCase);
              Arrays.sort(words,
                      (first, second) -> first.length() - second.length());
              Timer t = new Timer(1000, event -> {
                     System.out.println("At the tone, the time is " + new Date());
                     Toolkit.getDefaultToolkit().beep();
              });
//              t.start();
              // better that ActionListener interface in readable respect


              // methods reference     (System.out :: println)
              // just pass println method to Time constructor
              Timer t2 = new Timer(1000, System.out :: println);

       }
       public boolean test(String s) {
              return s == "just test";
       }

       public static void repeatMessage(String text, int delay) {
              ActionListener listener = event -> {
                     System.out.println(text);
                      // text+="illegal assignment"; // variable used in lambda expression should be final or effectively final
                     Toolkit.getDefaultToolkit().beep();
              };
              new Timer(delay, listener).start();
       }
}
interface Predicate<T> {
       boolean test(T t);
       // Additional default and static methods
}

class Greeter {
       public void greet() {
              System.out.println("Hello, world!");
       }

       public void greet(ActionEvent actionEvent) {
       }
}
class TimedGreeter extends Greeter {
       @Override
       // super :: instanceMethod
       public void greet() {
              Timer t = new Timer(1000, super::greet);
              t.start();
       }
}
