package lambda;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates the use of lambda expressions
 * @version 1.0
 * @author Cay Horstman
 */

public class LambdaTest {
       public static void main(String[] args) {
              String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn"};
              System.out.println(Arrays.toString(planets));
              System.out.println("Sorted in dictionary order: ");
              Arrays.sort(planets);
              System.out.println(Arrays.toString(planets));
              System.out.println("Sorted by length: ");
              Arrays.sort(planets, (first, second) -> first.length() - second.length());
              System.out.println(Arrays.toString(planets));

              Timer t = new Timer(1000, event -> System.out.println("This time is " + new Date()));
              t.start();

              // keep program running until user selects "OK"
              JOptionPane.showMessageDialog(null, "Quit Program ? ");
              System.exit(0);
       }
}
