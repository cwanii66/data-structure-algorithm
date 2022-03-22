package innerClass.anonymousInnerClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates anonymous inner classes
 * @version 1.11
 * @author Cay Hortman
 */

public class AnonymousInnerClassTest {
       public static void main(String[] args) {
              TalkingClock clock = new TalkingClock();
              clock.start(1000, true);

              // keep program running until user selects "ok"
              JOptionPane.showMessageDialog(null, "Quit program ?");
              System.exit(0);
       }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock {
       /**
        * Starts the clock
        * @param interval the interval between messages
        * @param beep true if the clock should beep
        */
       public void start(int interval, final boolean beep) {
              // Anonymous new ActionListener()
              ActionListener listener = new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                            System.out.println("At the tone, the time is " + new Date());
                            if (beep) Toolkit.getDefaultToolkit().beep();
                     }
              };
              Timer t = new Timer(interval, listener);
              t.start();
       }
}
