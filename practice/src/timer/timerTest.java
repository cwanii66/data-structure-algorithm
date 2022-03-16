package timer;

/**
 * @version 1.01
 * @author Cay Horstman
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
// to resolve conflict with java.util.Timer

public class timerTest {
       public static void main(String[] args) {
              ActionListener listener = new TimePrinter();

              // construct a timer that calls the listener
              // once every 10 seconds
              Timer t = new Timer(10000, listener);
              t.start();
              JOptionPane.showMessageDialog(null, "Quit program ?");
              System.exit(0);
       }
}
class TimePrinter implements ActionListener {
       public void actionPerformed(ActionEvent event) {
              System.out.println("At the tone, the time is " + new Date());
              Toolkit.getDefaultToolkit().beep();
       }
}

/*
       static void showMessageDialog(Component parent, Object message)
       Timer(int interval, ActionListener listener)
       void start()  call actionPerformed
       void stop()  stop actionPerformed
 */

